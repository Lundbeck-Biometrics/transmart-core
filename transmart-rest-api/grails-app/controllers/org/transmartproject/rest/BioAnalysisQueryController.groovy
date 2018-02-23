package org.transmartproject.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.transmartproject.core.exceptions.InvalidArgumentsException
import org.transmartproject.core.ontology.BioAnalysesResource
import org.transmartproject.core.ontology.BioAnalysis
import org.transmartproject.rest.marshallers.BioAnalysisWrapper
import org.transmartproject.rest.marshallers.ContainerResponseWrapper

import static org.transmartproject.rest.misc.RequestUtils.checkForUnsupportedParams


class BioAnalysisQueryController extends AbstractQueryController {
    static responseFormats = ['json', 'hal']

    @Autowired
    BioAnalysesResource bioAnalysesResource

    /**
     * BioAnalyses endpoint:
     * <code>/v2/bioanalyses</code>
     *
     * @return a list of {@link org.transmartproject.db.biomart.BioAssayAnalysis} objects
     */
    def listBioAnalyses(@RequestParam('api_version') String apiVersion) {
        checkForUnsupportedParams(params, [])
        def analyses = bioAnalysesResource.getBioAnalyses()
        respond wrapBioAnalyses(apiVersion, analyses)
    }

    /**
     * Study endpoint:
     * <code>/v2/bioanalyses/${id}</code>
     *
     * @param id the study id
     *
     * @return the {@link org.transmartproject.db.i2b2data.Study} object with id ${id}
     * if it exists and the user has access; null otherwise.
     */
    def findBioAnalysis(
            @RequestParam('api_version') String apiVersion,
            @PathVariable('id') Long id) {
        if (id == null) {
            throw new InvalidArgumentsException("Parameter 'id' is missing.")
        }
        checkForUnsupportedParams(params, ['id'])

        def analysis = bioAnalysesResource.getAnalysisForId(id)

        respond new BioAnalysisWrapper(
                analysis: analysis,
                apiVersion: apiVersion
        )
    }

    private static wrapBioAnalyses(String apiVersion, Collection<BioAnalysis> source) {
        new ContainerResponseWrapper(
                key: 'bioanalyses',
                container: source.collect { new BioAnalysisWrapper(apiVersion: apiVersion, analysis: it) },
                componentType: BioAnalysis,
        )
    }
}
