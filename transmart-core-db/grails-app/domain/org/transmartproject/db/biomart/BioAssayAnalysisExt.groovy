package org.transmartproject.db.biomart

class BioAssayAnalysisExt {

    static final String PUBLIC = 'PUBLIC'

    String genomeVersion
    String tissue
    String cellType
    String population
    String researchUnit
    String sampleSize
    String modelName
    String modelDescription

    static belongsTo=[bioAssayAnalysis: BioAssayAnalysis]

    static mapping = {
        table               name: 'BIO_ASSAY_ANALYSIS_EXT', schema: 'biomart'
        id column: 'BIO_ASSAY_ANALYSIS_EXT_ID', generator:'sequence', params:[sequence:'SEQ_BIO_DATA_ID']
        bioAssayAnalysis: 'BIO_ASSAY_ANALYSIS_ID'
        genomeVersion column:'GENOME_VERSION'
        tissue column:'TISSUE'
        cellType column:'CELL_TYPE'
        population column:'POPULATION'
        researchUnit column:'RESEARCH_UNIT'
        sampleSize column:'SAMPLE_SIZE'
        modelName column:'MODEL_NAME'
        modelDescription column:'MODEL_DESC'
        version false
    }

    static constraints = {
        genomeVersion nullable: true
        tissue nullable: true
        cellType nullable: true
        population nullable: true
        researchUnit nullable: true
        sampleSize nullable: true
        modelName nullable: true
        modelDescription nullable: true
    }

}