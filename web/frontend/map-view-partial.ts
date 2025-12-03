// Making transition to a Free Map library
//
// import MaplibreGeocoder, {
//     MaplibreGeocoderApi,
//     MaplibreGeocoderApiConfig,
//     CarmenGeojsonFeature,
//     MaplibreGeocoderFeatureResults,
//     MaplibreGeocoderPlaceResults,
//     MaplibreGeocoderOptions
// } from '@maplibre/maplibre-gl-geocoder';
// import MaplibreGl, {FlyToOptions, Marker, Popup, MarkerOptions, Map, GeoJSONFeature} from 'maplibre-gl';
// import '@maplibre/maplibre-gl-geocoder/dist/maplibre-gl-geocoder.css';
// import 'maplibre-gl/dist/maplibre-gl.css';
//
// declare global { interface Window {GetMap : any, ShowMap : any }}
//
// // import {waitUntil} from "workbox-core/_private";
//
// // var map , searchManager;
// // var mapsApiUrl = "https://www.bing.com/api/maps/mapcontrol?callback=GetMap";
// // var locationString;
// // @ts-ignore
// var map : Map;
// var locationString : string;
//
// var Geo: MaplibreGeocoderApi;
// var Config : MaplibreGeocoderApiConfig = {}
// var Options : MaplibreGeocoderOptions = {
//     maplibregl: MaplibreGl
// }
//
// window.GetMap = async function getMap() {
//
//     // @ts-ignore
//     map = new Map({
//             container: 'myMap',
//             // Use a minimalist raster style
//             style: 'https://tiles.openfreemap.org/styles/bright',
//             center: [-87.61694, 41.86625],
//             zoom: 15.99,
//             pitch: 40,
//             bearing: 20,
//             canvasContextAttributes: {antialias: true}
//     });
//     console.log(locationString + '  --- PROPERTY NULL ??? ----');
//
//     //Make a request to geocoder
//     geocodeRequest(locationString);
// }
//
// function geocodeRequest(location?: string) {
//     Config.query = location;
//     Geo = { async forwardGeocode(config):Promise<MaplibreGeocoderFeatureResults> {
//             var FeatureResults: MaplibreGeocoderFeatureResults = {features: [], type: "FeatureCollection"};
//             try {
//                 const request =
//                     `https://nominatim.openstreetmap.org/search?q=${config.query}&format=geojson&polygon_geojson=1&addressdetails=1`;
//                 const response: Response = await fetch(request);
//                 const geojson = await response.json();
//                 for (const feature of geojson.features) {
//                     const center: [number, number] = [
//                         feature.bbox[0] +
//                         (feature.bbox[2] - feature.bbox[0]) / 2,
//                         feature.bbox[1] +
//                         (feature.bbox[3] - feature.bbox[1]) / 2
//                     ];
//                     const point: CarmenGeojsonFeature = {
//                         id: feature.id,
//                         type: 'Feature',
//                         geometry: {
//                             type: 'Point',
//                             coordinates: center
//                         },
//                         place_name: feature.properties.display_name,
//                         properties: feature.properties,
//                         text: feature.properties.display_name,
//                         place_type: ['place'],
//                         bbox: [center[0], center[1], 0, 0],
//                     };
//                     FeatureResults.features.push(point);
//                 }
//             } catch (e) {
//                 console.error(`Failed to forwardGeocode with error: ${e}`);
//             }
//             return {
//                 features: FeatureResults.features, type: "FeatureCollection"
//             };
//         }
//     };
//     var Geocoder = new MaplibreGeocoder(Geo, Options);
//     Geo.forwardGeocode(Config);
// }
//
// window.ShowMap = function showMap(location: string){
//     var scripts = document.querySelectorAll(".map-per-request");
//     if (scripts.length === 0){
//     // scripts.forEach(scrp => {if(scrp.parentElement!=null) scrp.parentElement.removeChild(scrp)});
//
//         var head = document.getElementsByTagName("head")[0];
//
//         locationString = location;
//         var script = document.createElement("script");
//         script.className = "map-per-request";
//         script.type = "text/typescript";
//         script.async = true;
//         script.defer = true;
//         script.src = '';
//
//         script.onload = window.GetMap;
//
//         head.appendChild(script);
//     }
//     else (location)
//     var cross_origin_scripts = document.querySelectorAll("script[crossorigin=\"anonymus\"]");
//     cross_origin_scripts.forEach(sc => {if(sc.parentElement!=null) sc.parentElement.removeChild(sc)});
// }

import maplibregl, { Map } from "maplibre-gl";
import "maplibre-gl/dist/maplibre-gl.css";
import MaplibreGeocoder, {
    CarmenGeojsonFeature,
    MaplibreGeocoderApi,
    MaplibreGeocoderFeatureResults,
    MaplibreGeocoderOptions
} from "@maplibre/maplibre-gl-geocoder";
import "@maplibre/maplibre-gl-geocoder/dist/maplibre-gl-geocoder.css";

declare global {
    interface Window {
        ShowMap: (location: string) => void;
    }
}

let map: Map | null = null;

/* ---------------------------------------------
   Custom geocoder: calls Nominatim OSM
------------------------------------------------ */
const geoApi: MaplibreGeocoderApi = {
    async forwardGeocode(config): Promise<MaplibreGeocoderFeatureResults> {
        const url =
            `https://nominatim.openstreetmap.org/search?q=${config.query}&format=geojson`;

        const res = await fetch(url);
        const json = await res.json();

        const out: CarmenGeojsonFeature[] = json.features.map((f: any) => ({
            type: "Feature",
            id: f.id,
            geometry: {
                type: "Point",
                coordinates: [
                    f.bbox[0] + (f.bbox[2] - f.bbox[0]) / 2,
                    f.bbox[1] + (f.bbox[3] - f.bbox[1]) / 2
                ]
            },
            place_name: f.properties.display_name,
            text: f.properties.display_name,
            properties: f.properties,
            place_type: ["place"],
            bbox: f.bbox
        }));

        return { type: "FeatureCollection", features: out };
    }
};

/* ---------------------------------------------
   Initialize Map
------------------------------------------------ */
function initMap(location: string) {
    // If map exists, reuse container
    if (!map) {
        map = new maplibregl.Map({
            container: "myMap",
            style: "mapstyle/libertydark",
            center: [0, 0],
            zoom: 3
        });
    }

    // add geocoder
    const geocoder = new MaplibreGeocoder(geoApi, {
        maplibregl: maplibregl
    } as MaplibreGeocoderOptions);

    console.log( "!!!!!! Map controls: .....")
    console.log( map?._controls)

    // trigger geocoding search
    geocoder.getGeocoderApi().forwardGeocode({query: location})
        .then(result => {
            var centerFromBBOX: [number, number] = [0,0];
            var resultBBox: [number, number, number, number] = isNumberArray(result.features[0].bbox) ? result.features[0].bbox : [0,0,0,0];
            if ( result.features[0].bbox != undefined && isNumberArray(result.features[0].bbox) ) {
                centerFromBBOX[1] = resultBBox[1];
                centerFromBBOX[0] = resultBBox[0];
                map?.flyTo({center: centerFromBBOX, essential: true, zoom: 8});
            }
        } )
}

function isNumberArray(value: unknown): value is [number, number, number, number] {
    return Array.isArray(value) && value.every(item => typeof item === 'number' && !isNaN(item));
}

/* ---------------------------------------------
   Exposed to Java via executeJs
------------------------------------------------ */
window.ShowMap = function (location: string) {
    requestAnimationFrame(() => initMap(location));
};