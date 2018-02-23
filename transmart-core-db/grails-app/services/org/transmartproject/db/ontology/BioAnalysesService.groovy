package org.transmartproject.db.ontology

import grails.transaction.Transactional
import org.transmartproject.core.ontology.BioAnalysesResource
import org.transmartproject.core.ontology.BioAnalysis
import org.transmartproject.db.biomart.BioAssayAnalysis


@Transactional
class BioAnalysesService implements BioAnalysesResource {

    @Override
    List<BioAnalysis> getBioAnalyses() {
        org.transmartproject.db.biomart.BioAssayAnalysis.findAll()
    }

}
