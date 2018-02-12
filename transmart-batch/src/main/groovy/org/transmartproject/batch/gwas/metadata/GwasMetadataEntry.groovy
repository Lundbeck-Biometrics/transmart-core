package org.transmartproject.batch.gwas.metadata

import groovy.transform.ToString

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.constraints.Digits

/**
 * Represents a line in the GWAS metadata file.
 */
@ToString
class GwasMetadataEntry {
    public final static String GWAS_DATA_TYPE = 'GWAS'

    @NotNull
    @Size(min = 1, max = 500)
    String study

    @NotNull
    @Size(min = 1, max = 500)
    String shortDescription

    @NotNull
    @Size(min = 1, max = 4000)
    String longDescription

    @Size(max = 500)
    String researchUnit

    @NotNull
    @Pattern(regexp = 'GWAS', message = '{gwasDataTypes}')
    String dataType

    @NotNull
    @Size(max = 500)
    String traitInv

    @Size(max = 500)
    String population

    @Size(max = 500)
    String sampleSize

    @Size(max = 20)
    String numCtrls

    @Size(max = 20)
    String numCases

    @Size(max = 500)
    String tissue

    @Size(max = 500)
    String cellType

    @Size(max = 100)
    String modelName

    @Size(max = 500)
    String modelDescription

    @Digits(integer = 1, fraction = 10)
    BigDecimal pvalueCutoff

    @Size(max = 500)
    String analysisPlatform

    @Pattern(regexp = '1[8-9]', message = '{supportedGenomeVersions}')
    String genomeVersion

    @Size(max = 20)
    String snpDatabaseId

    @Size(max = 500)
    String inputFile

    @Size(max = 500)
    String pathSource

    @Size(max = 20)
    String datasetReleaseDate
}