package org.transmartproject.db.biomart

import org.transmartproject.core.ontology.Gwas

class GwasData implements Gwas {

    static final String PUBLIC = 'PUBLIC'

    Long bioAssayAnalysisId
    String rsId
    String pValueChar
    String effectAllele
    String otherAllele
    Double beta
    Double standardError
    Double logPValue

    static mapping = {
        table               name: 'bio_assay_analysis_gwas', schema: 'biomart'
        id                  column: 'bio_asy_analysis_gwas_id'
        bioAssayAnalysisId column: 'bio_assay_analysis_id'
        rsId column:'rs_id'
        pValueChar   column: 'p_value_char'
        logPValue column: 'log_p_value'
        effectAllele column: 'effect_allele'
        otherAllele column: 'other_allele'
        beta column: 'beta'
        standardError column: 'standard_error'
        version false
    }

    @Override String getPValueChar() {
        pValueChar
    }

    @Override Double getLogPValue() {
        logPValue
    }

}
