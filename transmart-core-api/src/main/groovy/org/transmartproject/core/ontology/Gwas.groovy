package org.transmartproject.core.ontology

import org.transmartproject.core.users.ProtectedResource

interface Gwas extends ProtectedResource {

    Long getId()

    String getPValueChar()

    Double getLogPValue()

}
