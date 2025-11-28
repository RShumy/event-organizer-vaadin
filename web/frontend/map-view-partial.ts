//Bing Sign up and Generate an API Key: https://www.bingmapsportal.com/

// Create file API-key.ts here in frontend folder with the uncommented lines below:
// const APIkey: string = "The-Bing-Maps-APIkey";
// export default APIkey;


import MaplibreGeocoder, {
    MaplibreGeocoderApi,
    MaplibreGeocoderApiConfig,
    CarmenGeojsonFeature,
    MaplibreGeocoderFeatureResults,
    MaplibreGeocoderPlaceResults,
    MaplibreGeocoderOptions
} from '@maplibre/maplibre-gl-geocoder';
import MaplibreGl, {FlyToOptions, Marker, Popup, MarkerOptions, Map, GeoJSONFeature} from 'maplibre-gl';
import '@maplibre/maplibre-gl-geocoder/dist/maplibre-gl-geocoder.css';
import 'maplibre-gl/dist/maplibre-gl.css';

declare global { interface Window {GetMap : any, ShowMap : any }}

// import {waitUntil} from "workbox-core/_private";

// var map , searchManager;
// var mapsApiUrl = "https://www.bing.com/api/maps/mapcontrol?callback=GetMap";
// var locationString;
// @ts-ignore
var map : Map;
var locationString : string;

window.GetMap = async function getMap() {

    // @ts-ignore
    map = new Map({
            container: 'map',
            // Use a minimalist raster style
            style: 'https://tiles.openfreemap.org/styles/bright',
            center: [-87.61694, 41.86625],
            zoom: 15.99,
            pitch: 40,
            bearing: 20,
            canvasContextAttributes: {antialias: true}
    });
    console.log(locationString + '  --- PROPERTY NULL ??? ----');

    //Make a request to geocoder
    let Geo: MaplibreGeocoderApi;
    var Config : MaplibreGeocoderApiConfig = { query:locationString }

    Geo = { async forwardGeocode(config):Promise<MaplibreGeocoderFeatureResults> {
            var FeatureResults: MaplibreGeocoderFeatureResults = {features: [], type: "FeatureCollection"};
            try {
                const request =
                    `https://nominatim.openstreetmap.org/search?q=${config.query}&format=geojson&polygon_geojson=1&addressdetails=1`;
                const response: Response = await fetch(request);
                const geojson = await response.json();
                for (const feature of geojson.features) {
                    const center: [number, number] = [
                        feature.bbox[0] +
                        (feature.bbox[2] - feature.bbox[0]) / 2,
                        feature.bbox[1] +
                        (feature.bbox[3] - feature.bbox[1]) / 2
                    ];
                    const point: CarmenGeojsonFeature = {
                        id: feature.id,
                        type: 'Feature',
                        geometry: {
                            type: 'Point',
                            coordinates: center
                        },
                        place_name: feature.properties.display_name,
                        properties: feature.properties,
                        text: feature.properties.display_name,
                        place_type: ['place'],
                        bbox: [center[0], center[1], 0, 0],
                    };
                    FeatureResults.features.push(point);
                }
            } catch (e) {
                console.error(`Failed to forwardGeocode with error: ${e}`);
            }
            return {
                features: FeatureResults.features, type: "FeatureCollection"
            };
        }

    };
    var Options : MaplibreGeocoderOptions = {
        maplibregl: MaplibreGl
    }
    const Geocoder= new MaplibreGeocoder(Geo, Options);
}

window.ShowMap = function showMap(location: string){
    var scripts = document.querySelectorAll(".map-per-request");
    if (scripts.length === 0){
    // scripts.forEach(scrp => {if(scrp.parentElement!=null) scrp.parentElement.removeChild(scrp)});

        var head = document.getElementsByTagName("head")[0];

        locationString = location;
        var script = document.createElement("script");
        script.className = "map-per-request";
        script.type = "text/javascript";
        script.async = true;
        script.defer = true;
        script.src = '';

        script.onload = window.GetMap;

        head.appendChild(script);
    }
    else (location)
    var cross_origin_scripts = document.querySelectorAll("script[crossorigin=\"anonymus\"]");
    cross_origin_scripts.forEach(sc => {if(sc.parentElement!=null) sc.parentElement.removeChild(sc)});
}








