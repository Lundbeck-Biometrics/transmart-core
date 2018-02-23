package org.transmartproject.db.ontology

import grails.transaction.Transactional
import org.transmartproject.core.exceptions.NoSuchResourceException
import org.transmartproject.core.ontology.BioAnalysesResource
import org.transmartproject.core.ontology.BioAnalysis
import org.transmartproject.db.biomart.BioAssayAnalysis


@Transactional
class BioAnalysesService implements BioAnalysesResource {

    @Override
    List<BioAnalysis> getBioAnalyses() {
        org.transmartproject.db.biomart.BioAssayAnalysis.findAll()
    }

    @Override
    BioAnalysis getAnalysisForId(Long id) throws NoSuchResourceException {
        org.transmartproject.db.biomart.BioAssayAnalysis.findById(id)
    }

}
