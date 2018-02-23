/* (c) Copyright 2017, tranSMART Foundation, Inc. */

package org.transmartproject.db.biomart

import org.transmartproject.core.ontology.BioAnalysis

class BioAssayAnalysis implements BioAnalysis {

    static final String PUBLIC = 'PUBLIC'

    String bioAssayAnalysisName

    static constraints = {
        bioAssayAnalysisId             maxSize: 100
        bioAssayAnalysisName   maxSize: 500
    }

    static mapping = {
        table               name: 'bio_assay_analysis', schema: 'biomart'
        id                  column: 'bio_assay_analysis_id', type: Long, generator: 'sequence', params: [sequence: 'SEQ_BIO_DATA_ID']
        bioAssayAnalysisName   column: 'analysis_name'
        version false
    }

    @Override String getName() {
        bioAssayAnalysisName
    }
}
