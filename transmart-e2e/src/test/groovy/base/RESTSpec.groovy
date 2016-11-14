package base

import grails.converters.JSON
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.grails.web.json.JSONObject
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import spock.lang.Shared
import spock.lang.Specification

import java.text.SimpleDateFormat

import static config.Config.*
import static org.hamcrest.Matchers.*

/**
 * Created by barteldklasens on 10/24/16.
 */
class RESTSpec extends Specification{

    def contentTypeForHAL = 'application/hal+json'
    def contentTypeForJSON = 'application/json'

    @Shared
    private String oauth2token
    @Shared
    private http = new HTTPBuilder(BASE_URL)

    def oauth2Authenticate(){
        def json = post('oauth/token', contentTypeForJSON, ['grant_type': 'password', 'client_id': 'glowingbear-js', 'client_secret': '', 'username': GOOD_USERNAME, 'password': GOOD_PASSWORD], null, ContentType.TEXT, false)

        if (DEBUG){
            println "Authenticate: username=${GOOD_USERNAME} password=${GOOD_PASSWORD} token=${json.access_token}"
        }
        oauth2token = json.access_token
    }

    def getToken(){
        if (oauth2token == null){
            oauth2Authenticate()
        }
        return oauth2token
    }

    /**
     *
     * a convenience method to keep the tests readable by removing as much code as possible
     *
     * @param path
     * @param AcceptHeader
     * @param queryMap
     * @param requestBody
     * @param contentType
     * @param oauth
     * @return
     */
    def post(String path, String AcceptHeader, queryMap, requestBody = null, contentType, oauth = true ){
        http.request(Method.POST, ContentType.TEXT){
            uri.path = path
            uri.query = queryMap
            body = requestBody
            headers.Accept = AcceptHeader
            headers.'Content-Type' = 'text/xml'
            if (oauth && OAUTH_NEEDED){
                headers.'Authorization' = 'Bearer ' + getToken()
            }

            response.success = { resp, reader ->
                if (DEBUG){
                    println "Got response: ${resp.statusLine}"
                    println "Content-Type: ${resp.headers.'Content-Type'}"
                    JSONObject result = JSON.parse(reader)
                    println result
                    return result
                }
                return JSON.parse(reader)
            }

            response.failure = { resp, reader ->
                if (DEBUG){
                    println "Got response: ${resp.statusLine}"
                    println "Content-Type: ${resp.headers.'Content-Type'}"
                    def result = JSON.parse(reader)
                    println result
                    return result
                }

                return JSON.parse(reader)
            }
        }

    }

    /**
     * a convenience method to keep the tests readable by removing as much code as possible
     *
     * @param path
     * @param AcceptHeader
     * @param queryMap
     * @return
     */
    def get(String path, String AcceptHeader, queryMap = null){
        http.request(Method.GET, ContentType.TEXT) { req ->
            uri.path = path
            uri.query = queryMap
            headers.Accept = AcceptHeader
            if (OAUTH_NEEDED){
                headers.'Authorization' = 'Bearer ' + getToken()
            }

            response.success = { resp, reader ->
                assert resp.statusLine.statusCode >= 200
                assert resp.statusLine.statusCode < 400
                assert resp.headers.'Content-Type'.contains(AcceptHeader)
                if (DEBUG){
                    println "Got response: ${resp.statusLine}"
                    println "Content-Type: ${resp.headers.'Content-Type'}"
                    def result = JSON.parse(reader)
                    println result
                    return result
                }
                return JSON.parse(reader)
            }

            response.failure = { resp, reader ->
                assert resp.statusLine.statusCode >= 400
                if (DEBUG){
                println "Got response: ${resp.statusLine}"
                println "Content-Type: ${resp.headers.'Content-Type'}"
                def result = JSON.parse(reader)
                println result
                return result
                }

                return JSON.parse(reader)
            }
        }
    }

    /**
     * takes a map of constraints and returns a json query
     *
     * @param constraints
     * @return
     */
    def toQuery(constraints){
        return [constraint: new JsonBuilder(constraints)]
    }

    def toJSON(object){
        return new JsonBuilder(object)
    }

    def toDateString(dateString, inputFormat = "dd-MM-yyyyX"){
        def date = new SimpleDateFormat(inputFormat).parse(dateString)
        date.format("yyyy-MM-dd'T'HH:mm:ssX", TimeZone.getTimeZone('Z'))
    }

    /**
     * Generic matcher for a hal index response, expecting 2 entries:
     * - selfLink
     * - _embedded[embeddedMatcherMap*key:value]
     * @param selfLink
     * @param embeddedMatcherMap map of key to matcher elements to be expected inside '_embedded'
     * @return
     */
    def halIndexResponse(String selfLink, Map<String, Matcher> embeddedMatcherMap) {

        allOf(
                hasSelfLink(selfLink),
                hasEntry(
                        is('_embedded'),
                        allOf(
                                embeddedMatcherMap.collect {
                                    hasEntry(is(it.key), it.value)
                                }
                        )
                ),
        )
    }



    /**
     * Generic matcher for a hal index response, expecting 2 entries:
     * - selfLink
     * - _embedded[embeddedMatcherMap*key:value]
     * @param selfLink
     * @param embeddedMatcherMap map of key to matcher elements to be expected inside '_embedded'
     * @return
     */
    def halIndexResponse(String selfLink, List<Matchers> embeddedMatcherList) {

        allOf(
                hasSelfLink(selfLink),
                hasEntry(
                        is('_embedded'),
                        allOf(
                                embeddedMatcherList
                        )
                ),
        )
    }

    /**
     * Matcher for a map entry containing _links.self[href:selfLink]
     * @param selfLink value of the expected link
     * @return matcher
     */
    def hasSelfLink(String selfLink) {
        hasEntry(
                is('_links'),
                hasEntry(
                        is('self'), hasEntry('href', selfLink)
                ),
        )
    }

    /**
     * Matcher for a map entry containing _links.self[href:selfLink]
     * @param selfLink value of the expected link
     * @return matcher
     */
    def hasChildrenLink(String selfLink) {
        hasEntry(
                is('_links'),
                hasEntry(
                        is('children'), hasEntry('href', selfLink)
                ),
        )
    }
}