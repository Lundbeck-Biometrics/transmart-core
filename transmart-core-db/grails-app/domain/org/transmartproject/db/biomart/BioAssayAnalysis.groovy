package org.transmartproject.db.biomart

import org.transmartproject.core.ontology.BioAnalysis

class BioAssayAnalysis implements BioAnalysis {

    static final String PUBLIC = 'PUBLIC'

    String bioAssayAnalysisName
    String assayDataType
    String shortDescription
    String longDescription
    Double pValueCutoff
    Long dataCount

    static constraints = {
        bioAssayAnalysisId             maxSize: 100
        bioAssayAnalysisName   maxSize: 500
    }

    static hasOne=[ext:BioAssayAnalysisExt]

    static mapping = {
        table               name: 'bio_assay_analysis', schema: 'biomart'
        id                  column: 'bio_assay_analysis_id', type: Long, generator: 'sequence', params: [sequence: 'SEQ_BIO_DATA_ID']
        bioAssayAnalysisName   column: 'analysis_name'
        assayDataType column:'bio_assay_data_type'
        shortDescription column:'short_description'
        longDescription column:'long_description'
        pValueCutoff column:'pvalue_cutoff'
        dataCount column:'data_count'
        ext joinTable:[name:'BIO_ASSAY_ANALYSIS_EXT', schema:'biomart']
        version false
    }

    @Override String getName() {
        bioAssayAnalysisName
    }

    @Override String getDataType() {
        assayDataType
    }

    @Override Double getPValueCutoff() {
        pValueCutoff
    }

}
