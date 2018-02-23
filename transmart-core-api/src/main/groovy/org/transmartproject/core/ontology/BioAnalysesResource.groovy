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
     * @return the analysis with the id, if it exists
     * @throws org.transmartproject.core.exceptions.NoSuchResourceException iff no study can be found with the id
     */
    BioAnalysis getAnalysisForId(Long id) throws NoSuchResourceException

    /**
     * Returns all bio analyses.
     *
     * @return the bio analyses.
     */
    List<BioAnalysisExt> getBioAnalysesExt()

    /**
     * Returns the analysis with the given id.
     *
     * @param id the database identifier of the analysis
     * @return the analysis with the id, if it exists
     * @throws org.transmartproject.core.exceptions.NoSuchResourceException iff no study can be found with the id
     */
    BioAnalysisExt getAnalysisExtForId(Long id) throws NoSuchResourceException


}
