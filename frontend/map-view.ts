// Issues over issues too much time spent on research/ tried many different implementations , need a TypeScript master to guide me through this

// import APIkey from './API-key';
// import SearchManager = Microsoft.Maps.Search.SearchManager;
// declare global { interface Window {GetMap : any, ShowMap : any }}
// var map : Microsoft.Maps.Map, searchManager : SearchManager;
// var mapsApiUrl : string = "https://www.bing.com/api/maps/mapcontrol?callback=GetMap";
// var locationString : string;
//
// window.GetMap = function GetMap() {
//     var mapElement = document.getElementById('myMap')
//     if (map == null && mapElement != null) map = new Microsoft.Maps.Map(mapElement, {
//         credentials : APIkey
//     });
//     //Make a request to geocode New York, NY.
//     geocodeQuery(locationString);
// }
//
// function geocodeQuery(query : string) {
//             //If search manager is not defined, load the search module.
//         if (!searchManager) {
//             //Create an instance of the search manager and call the geocodeQuery function again.
//
//             console.log("------- BEFORE LOADING SEARCH MODULE -------")
//             Microsoft.Maps.loadModule('Microsoft.Maps.Search', async function () {
//             searchManager = new Microsoft.Maps.Search.SearchManager(map);
//             console.log("------- AFTER LOADING SEARCH MODULE -------")
//             await geocodeQuery(query);
//         });
//         } else {
//             var searchRequest = {
//             where: query,
//             callback: function (r : any) {
//             //Add the first result to the map and zoom into it.
//             if (r && r.results && r.results.length > 0) {
//             var pin = new Microsoft.Maps.Pushpin(r.results[0].location);
//             map.entities.push(pin);
//
//             map.setView({ bounds: r.results[0].bestView });
//         }
//         },
//             errorCallback: function (e : any) {
//             //If there is an error, alert the user about it.
//             alert("No results found.");
//         }
//         };
//
//             //Make the geocode request.
//             searchManager.geocode(searchRequest);
//         }
// }
//
// window.ShowMap = function ShowMap(location : string
//                                   , callback : any
//                                                 ){
//         var scripts = document.querySelectorAll(".map-per-request");
//         scripts.forEach(scrp => {if(scrp.parentElement!=null) scrp.parentElement.removeChild(scrp)});
//         // var cross_origin_scripts = document.querySelectorAll("script[crossorigin=\"anonymus\"]");
//         // cross_origin_scripts.forEach(sc => {if(sc.parentElement!=null) sc.parentElement.removeChild(sc)});
//         var head = document.getElementsByTagName("head")[0];
//
//         locationString = location;
//         var script = document.createElement("script");
//         script.className = "map-per-request";
//         script.type = "text/javascript";
//         script.async = true;
//         script.defer = true;
//         script.src = mapsApiUrl;
//         script.onload = callback;
//
//         head.appendChild(script);
// }






