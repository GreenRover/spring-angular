/**
 * RoalerCoster
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: max@muster.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { Sort } from './sort';

export interface Pageable { 
    offset?: number;
    sort?: Sort;
    pageSize?: number;
    pageNumber?: number;
    paged?: boolean;
    unpaged?: boolean;
}