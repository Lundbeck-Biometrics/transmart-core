package org.transmartproject.db.ontology

import grails.transaction.Transactional
import org.transmartproject.core.exceptions.NoSuchResourceException
import org.transmartproject.core.ontology.BioAnalysesResource
import org.transmartproject.core.ontology.BioAnalysis
import org.transmartproject.core.ontology.BioAnalysisExt

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

    @Override
    List<BioAnalysisExt> getBioAnalysesExt() {
        org.transmartproject.db.biomart.BioAssayAnalysisExt.findAll()
    }

    @Override
    BioAnalysisExt getAnalysisExtForId(Long id) throws NoSuchResourceException {
        org.transmartproject.db.biomart.BioAssayAnalysisExt.findById(id)
    }

}
