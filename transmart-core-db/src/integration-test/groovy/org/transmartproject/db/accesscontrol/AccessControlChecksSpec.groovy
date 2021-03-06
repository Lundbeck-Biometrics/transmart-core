package org.transmartproject.db.accesscontrol

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import org.springframework.beans.factory.annotation.Autowired
import org.transmartproject.db.i2b2data.Study
import org.transmartproject.db.ontology.I2b2Secure
import org.transmartproject.db.user.User
import spock.lang.Specification

import static org.transmartproject.core.users.ProtectedOperation.WellKnownOperations.READ
import static org.transmartproject.core.users.ProtectedOperation.WellKnownOperations.SHOW_SUMMARY_STATISTICS

@Rollback
@Integration
class AccessControlChecksSpec extends Specification {

    @Autowired
    AccessControlChecks accessControlChecks

    def 'check access to a node'() {
        expect:
        canPerformReadOnTheNode == accessControlChecks.canPerform(
                User.findByUsername(user),
                operation,
                I2b2Secure.findByFullName(node)
        )

        where:
        user                 | operation               | node                                                                 | canPerformReadOnTheNode
        'test-public-user-1' | SHOW_SUMMARY_STATISTICS | '\\Public Studies\\SHARED_CONCEPTS_STUDY_A\\Demography\\Age\\'       | true
        'test-public-user-1' | READ                    | '\\Public Studies\\SHARED_CONCEPTS_STUDY_A\\Demography\\Age\\'       | true
        'test-public-user-1' | SHOW_SUMMARY_STATISTICS | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | false
        'test-public-user-1' | READ                    | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | false
        'test-public-user-2' | SHOW_SUMMARY_STATISTICS | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | true
        'test-public-user-2' | READ                    | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | false
        'admin'              | SHOW_SUMMARY_STATISTICS | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | true
        'admin'              | READ                    | '\\Private Studies\\SHARED_CONCEPTS_STUDY_C_PRIV\\Demography\\Age\\' | true
    }

    def 'check access to a study'() {
        expect:
        canPerformReadOnTheStudy == accessControlChecks.canPerform(
                User.findByUsername(user),
                operation,
                Study.findByStudyId(studyId)
        )

        where:
        user                 | operation               | studyId                        | canPerformReadOnTheStudy
        'test-public-user-1' | SHOW_SUMMARY_STATISTICS | 'SHARED_CONCEPTS_STUDY_A'      | true
        'test-public-user-1' | READ                    | 'SHARED_CONCEPTS_STUDY_A'      | true
        'test-public-user-1' | SHOW_SUMMARY_STATISTICS | 'SHARED_CONCEPTS_STUDY_C_PRIV' | false
        'test-public-user-1' | READ                    | 'SHARED_CONCEPTS_STUDY_C_PRIV' | false
        'test-public-user-2' | SHOW_SUMMARY_STATISTICS | 'SHARED_CONCEPTS_STUDY_C_PRIV' | true
        'test-public-user-2' | READ                    | 'SHARED_CONCEPTS_STUDY_C_PRIV' | false
        'admin'              | SHOW_SUMMARY_STATISTICS | 'SHARED_CONCEPTS_STUDY_C_PRIV' | true
        'admin'              | READ                    | 'SHARED_CONCEPTS_STUDY_C_PRIV' | true
    }
}
