/**
 * OpenAPI definition
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

/**
 * The list of all applications visible for current user.
 */
export interface ZugIdentifikation { 
    zugnummer: string;
    /**
     * RWEI was ist das?
     */
    erweiterungszeichen?: string;
    /**
     * RWEI was ist das?
     */
    betreibercode?: string;
    /**
     * RWEI was ist das?
     */
    lenkziffer?: string;
}