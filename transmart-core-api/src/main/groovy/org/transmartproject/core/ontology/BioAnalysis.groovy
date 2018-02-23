package org.transmartproject.core.ontology

import org.transmartproject.core.users.ProtectedResource

interface BioAnalysis extends ProtectedResource {

    Long getId()

    String getName()

}
