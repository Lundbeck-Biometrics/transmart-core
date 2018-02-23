package org.transmartproject.core.ontology

import org.transmartproject.core.exceptions.NoSuchResourceException
import org.transmartproject.core.users.User

interface BioAnalysesResource {

    /**
     * Returns all bio analyses.
     *
     * @return the bio analyses.
     */
    List<BioAnalysis> getBioAnalyses()

    /**
     * Returns the analysis with the given id.
     *
     * @param id the database identifier of the analysis
     * @return the study with the id, if it exists and the user has access to the study.
     * @throws org.transmartproject.core.exceptions.NoSuchResourceException iff no study can be found with the id or the user does not have
     * access to the study.
     */
    BioAnalysis getAnalysisForId(Long id) throws NoSuchResourceException


}
