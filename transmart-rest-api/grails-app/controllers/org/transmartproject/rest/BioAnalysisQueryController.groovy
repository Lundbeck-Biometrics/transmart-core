package org.transmartproject.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestParam
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

    private static wrapBioAnalyses(String apiVersion, Collection<BioAnalysis> source) {
        new ContainerResponseWrapper(
                key: 'bioanalyses',
                container: source.collect { new BioAnalysisWrapper(apiVersion: apiVersion, analysis: it) },
                componentType: BioAnalysis,
        )
    }
}
