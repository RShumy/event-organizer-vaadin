package com.eventorganizr.organizr;

import com.eventorganizr.organizr.entity.Authority;
import com.eventorganizr.organizr.entity.Consumable;
import com.eventorganizr.organizr.entity.Event;
import com.eventorganizr.organizr.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

public class InitCLR {

    @Bean
    public static CommandLineRunner initialize(AuthorityService authorityService , UserService userService,
                                               EventService eventService, ParticipantService participantService,
                                               ConsumableService consumableService) throws Exception {
        return args -> {
            // Authorities Hardcoded Data Insert
            {
                authorityService.saveAuthority(new Authority("ROLE_USER"));
                authorityService.saveAuthority(new Authority("ROLE_EVENT_ORGANIZER"));
                authorityService.saveAuthority(new Authority("ROLE_ADMIN"));
            }
            // User with Authorities Hardcoded Data Insert
            {
                userService.createUser("user", "Lynnett", "East", "least0@trellian.com", "user", true)
                        .withAuthorities(authorityService.findAuthority(3)).create();
                userService.createUser("svennings1", "Stafani", "Vennings", "svennings1@51.la", "9VJIgDt", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("tbenedicte2", "Thadeus", "Benedicte", "tbenedicte2@clickbank.net", "31c3nEeRPO", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("hstanlick3", "Herve", "Stanlick", "hstanlick3@ucoz.com", "SymjwWE7", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("lcanavan4", "Lionel", "Canavan", "lcanavan4@quantcast.com", "spvz0pA", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("mthresher5", "Meggy", "Thresher", "mthresher5@clickbank.net", "P94IFXCbuW3p", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("cgildea6", "Camala", "Gildea", "cgildea6@printfriendly.com", "RfwpsT", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("jtille7", "Jasen", "Tille", "jtille7@japanpost.jp", "owmohGSi0cxY", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("gfooks8", "Goddart", "Fooks", "gfooks8@nhs.uk", "T0YfekmB", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("cwimbridge9", "Claretta", "Wimbridge", "cwimbridge9@sina.com.cn", "ozGGKYVukmp", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("rjolya", "Ricky", "Joly", "rjolya@epa.gov", "volWmm0K", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("mkiggelb", "Maynard", "Kiggel", "mkiggelb@army.mil", "mCpFC7YfZ", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("aburragec", "Audy", "Burrage", "aburragec@privacy.gov.au", "bpEdPIZodwR", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("ekerid", "Earvin", "Keri", "ekerid@so-net.ne.jp", "rqepxrDdO", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("laltone", "Lanni", "Alton", "laltone@cloudflare.com", "eCOexbUMdGf", true)
                        .withAuthorities(authorityService.findAuthority(2)).create();
                userService.createUser("dkunklerf", "Daryl", "Kunkler", "dkunklerf@hexun.com", "hEl55ykOF5p0", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("tfeekg", "Tomasine", "Feek", "tfeekg@hibu.com", "U4JZuvRK45", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("bweatherdonh", "Bonnee", "Weatherdon", "bweatherdonh@plala.or.jp", "WkbU4jflXR", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cbertsoni", "Carma", "Bertson", "cbertsoni@imdb.com", "AdtV943aisrC", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cyulej", "Chad", "Yule", "cyulej@sbwire.com", "KNNynhk6", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("gcollissk", "Glenn", "Colliss", "gcollissk@hhs.gov", "AmIYqdaef", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("fhaymesl", "Fonsie", "Haymes", "fhaymesl@miibeian.gov.cn", "4YfkxeGiI8DP", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("aarondelm", "Aggy", "Arondel", "aarondelm@wikia.com", "PEPltFAxT9D", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("lpetzoltn", "Lilli", "Petzolt", "lpetzoltn@histats.com", "XxyiE4e5gin", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("eslimano", "Eugenia", "Sliman", "eslimano@netvibes.com", "gBJJ3ti", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cmcgrayp", "Clive", "McGray", "cmcgrayp@businessinsider.com", "sdzwoMlAE2", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("smacconnalq", "Stanwood", "MacConnal", "smacconnalq@psu.edu", "iyCOTYO", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("heatonr", "Halli", "Eaton", "heatonr@globo.com", "2a4m0KWOxt", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("eblofelds", "Emma", "Blofeld", "eblofelds@techcrunch.com", "Yg1Hk7owi", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("scohent", "Sadie", "Cohen", "scohent@ovh.net", "vxf1NFpmIkG", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("agerrardu", "Amalee", "Gerrard", "agerrardu@geocities.jp", "D2Oz9TBYA4n", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("twitteringv", "Teressa", "Wittering", "twitteringv@flickr.com", "h9FCRdqcKwr", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kaspinwallw", "Kiel", "Aspinwall", "kaspinwallw@trellian.com", "TP9Gh9LY", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kblackburnex", "Kort", "Blackburne", "kblackburnex@devhub.com", "ByRzpXJ3Hdl6", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cmatthiesony", "Chris", "Matthieson", "cmatthiesony@oaic.gov.au", "KJa13bd", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("fvanderveldenz", "Fiann", "Van der Velden", "fvanderveldenz@tinypic.com", "GyBgFEE", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("rbillo10", "Robinette", "Billo", "rbillo10@sohu.com", "37NM0TKJU", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("mbrandone11", "Marjory", "Brandone", "mbrandone11@blogtalkradio.com", "zhKIcP3IvZE2", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("klimbert12", "Karim", "Limbert", "klimbert12@tinyurl.com", "kUy7dLj2O", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kdohr13", "Kendell", "Dohr", "kdohr13@si.edu", "uucdNjGFsdy0", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("ady14", "Amos", "Dy", "ady14@eventbrite.com", "GWuWfobwEG", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("brobiou15", "Blair", "Robiou", "brobiou15@discovery.com", "XHswyn6f", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("fkorbmaker16", "Fayette", "Korbmaker", "fkorbmaker16@twitter.com", "6RgASGR", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("sceliz17", "Siouxie", "Celiz", "sceliz17@virginia.edu", "ThI8Yn", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("rdussy18", "Roberto", "Dussy", "rdussy18@deliciousdays.com", "gsuEt5Jq", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("icaudelier19", "Innis", "Caudelier", "icaudelier19@unesco.org", "N8HTtwledYq", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("lhedgeley1a", "Ludovico", "Hedgeley", "lhedgeley1a@amazon.co.jp", "Y4UjY8sQo", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("prosborough1b", "Pincas", "Rosborough", "prosborough1b@whitehouse.gov", "FZKPGk", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("vrubinek1c", "Vance", "Rubinek", "vrubinek1c@ed.gov", "zPMu6HH4tY5w", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kabramowitch1d", "Kacy", "Abramowitch", "kabramowitch1d@skyrock.com", "WOWY4ac", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("dkleinpeltz1e", "Davita", "Kleinpeltz", "dkleinpeltz1e@weather.com", "MJ2peBCd3Igc", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("gdenrico1f", "Giavani", "DEnrico", "gdenrico1f@mit.edu", "43gR9di8G", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("ajerger1g", "Alexine", "Jerger", "ajerger1g@samsung.com", "5Cq0GUBeLx", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("hbennis1h", "Hildagard", "Bennis", "hbennis1h@smh.com.au", "qyMoFzx", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("ldrummer1i", "Lonnie", "Drummer", "ldrummer1i@ucoz.ru", "JlJs34O9", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("aelgie1j", "Adelle", "Elgie", "aelgie1j@cbc.ca", "A4nd3Ia", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("jgreenmon1k", "Jessa", "Greenmon", "jgreenmon1k@nps.gov", "r1i0gv", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("lstilwell1l", "Lindsay", "Stilwell", "lstilwell1l@com.com", "fEIYp86a", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("hnappin1m", "Hermann", "Nappin", "hnappin1m@fema.gov", "fauhhIl", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("tmilesap1n", "Thaddus", "Milesap", "tmilesap1n@google.com.au", "FHY2ssRY", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("iyurkov1o", "Ianthe", "Yurkov", "iyurkov1o@cloudflare.com", "3MPeItnwpzsX", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("dfrome1p", "Demetre", "Frome", "dfrome1p@tamu.edu", "38blJqlY4", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("wsloat1q", "Winne", "Sloat", "wsloat1q@naver.com", "hMPCVn5DW3h", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("snulty1r", "Shelly", "Nulty", "snulty1r@europa.eu", "qf1XEw", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cstorkes1s", "Corine", "Storkes", "cstorkes1s@google.it", "Q4whWm23s", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("mstroobant1t", "Mallorie", "Stroobant", "mstroobant1t@meetup.com", "nhgfRMLIL", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("mtarrier1u", "Marsha", "Tarrier", "mtarrier1u@wordpress.com", "OBjN0uFTFZCn", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("emcbrearty1v", "Eleonora", "McBrearty", "emcbrearty1v@weibo.com", "BT0LhjFu6cY", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("udavydoch1w", "Umeko", "Davydoch", "udavydoch1w@phpbb.com", "pKuV4VQ7W5", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kroizn1x", "Kyle", "Roizn", "kroizn1x@independent.co.uk", "P7GCpeVd9cAW", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("qroskelly1y", "Quill", "Roskelly", "qroskelly1y@earthlink.net", "MzGU9jpaoO6", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("mpyford1z", "Meagan", "Pyford", "mpyford1z@globo.com", "gWwgSwfy", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("asange20", "Annamaria", "Sange", "asange20@people.com.cn", "R0ifb06YId", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cesselen21", "Cherish", "Esselen", "cesselen21@sina.com.cn", "9I1SKV", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("nforo22", "Niel", "Foro", "nforo22@buzzfeed.com", "zqlzBQ", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("zjoyce23", "Zared", "Joyce", "zjoyce23@oakley.com", "JAWiKhcHpbNV", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("wabbott24", "Wynn", "Abbott", "wabbott24@google.fr", "vwzkZWxV1", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("dlawrenz25", "Dulcine", "Lawrenz", "dlawrenz25@bluehost.com", "qcfEw9", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("agreder26", "Amble", "Greder", "agreder26@chron.com", "VtpR9KgHLhLA", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("mrubel27", "Mathe", "Rubel", "mrubel27@nps.gov", "PJD8gTJFiF5", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cmartugin28", "Chloette", "Martugin", "cmartugin28@fema.gov", "Ijj7MgAjE", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("twanley29", "Tarah", "Wanley", "twanley29@blinklist.com", "iElgHW", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cbowle2a", "Costanza", "Bowle", "cbowle2a@t.co", "R3ItEhqn", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("jasher2b", "Jerrie", "Asher", "jasher2b@abc.net.au", "GjyZjrPvfX93", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("kridel2c", "Kiley", "Ridel", "kridel2c@domainmarket.com", "Bfh6C6Gdc5", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("sgiraudy2d", "Staci", "Giraudy", "sgiraudy2d@friendfeed.com", "6z7uvB", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("tdrake2e", "Theresina", "Drake", "tdrake2e@wired.com", "jgw2nEuMSk", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("ecarder2f", "Esta", "Carder", "ecarder2f@ihg.com", "zpqHYJEt4", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("prawcliffe2g", "Petunia", "Rawcliffe", "prawcliffe2g@cocolog-nifty.com", "dCL9xX", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("atomczykowski2h", "Abagael", "Tomczykowski", "atomczykowski2h@harvard.edu", "7Tj3X7DI", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("abrager2i", "Ange", "Brager", "abrager2i@unc.edu", "91kUxXFvsW1Z", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("hjoslin2j", "Henriette", "Joslin", "hjoslin2j@abc.net.au", "t4LjDZkeVy4", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("csijmons2k", "Charlena", "Sijmons", "csijmons2k@utexas.edu", "FVNg8sn6", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("tondricek2l", "Tallulah", "Ondricek", "tondricek2l@yellowbook.com", "qFwDDIKxZCU", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cpatience2m", "Caterina", "Patience", "cpatience2m@abc.net.au", "dTFc0zUGAHIZ", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cgroocock2n", "Cordell", "Groocock", "cgroocock2n@marketwatch.com", "KPZ8BQz", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cpryke2o", "Cesya", "Pryke", "cpryke2o@mysql.com", "XpQY9jfhO", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("djurca2p", "Duane", "Jurca", "djurca2p@sohu.com", "3QDwvj69kiO", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("cbelson2q", "Codee", "Belson", "cbelson2q@timesonline.co.uk", "k8atQrVO7e", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
                userService.createUser("jswine2r", "Jacquelynn", "Swine", "jswine2r@deliciousdays.com", "Rnebwgcw", true)
                        .withAuthorities(authorityService.findAuthority(1)).create();
            }
            // Event Hardcoded Data Insert
            {
                eventService.saveEvent(new Event("Event Deirdre", LocalDateTime.parse("2022-06-22T01:12:19"), LocalDateTime.parse("2023-01-24T17:47:52"), "Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl.", "Bvd 21 Decembrie, Nr.20, Cluj-Napoca", 1L));
                eventService.saveEvent(new Event("Event Faith", LocalDateTime.parse("2023-03-30T19:22:36"), LocalDateTime.parse("2022-12-23T09:38:56"), "pede nec ante blandit viverra. Donec", "Poitiers", 3L));
                eventService.saveEvent(new Event("Event Yoko", LocalDateTime.parse("2022-05-30T22:36:38"), LocalDateTime.parse("2022-06-22T23:16:59"), "dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales", "Homburg", 6L));
                eventService.saveEvent(new Event("Event Selma", LocalDateTime.parse("2023-04-19T20:41:18"), LocalDateTime.parse("2023-03-01T05:15:24"), "dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis", "Bremerhaven", 9L));
                eventService.saveEvent(new Event("Event Tobias", LocalDateTime.parse("2023-01-28T13:33:25"), LocalDateTime.parse("2024-02-20T08:24:57"), "tincidunt orci quis lectus. Nullam suscipit, est ac facilisis", "Aachen", 10L));
                eventService.saveEvent(new Event("Event Harrison", LocalDateTime.parse("2023-11-18T01:20:48"), LocalDateTime.parse("2022-07-23T23:09:41"), "urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi.", "Cáceres", 1L));
                eventService.saveEvent(new Event("Event Victor", LocalDateTime.parse("2024-01-20T17:30:13"), LocalDateTime.parse("2022-07-13T12:10:10"), "lectus ante dictum mi, ac mattis velit", "Bad Dürkheim", 1L));
                eventService.saveEvent(new Event("Event Desirae", LocalDateTime.parse("2023-02-21T11:27:51"), LocalDateTime.parse("2023-09-25T12:18:43"), "tincidunt adipiscing. Mauris molestie pharetra nibh.", "Forbach", 5L));
                eventService.saveEvent(new Event("Event Julian", LocalDateTime.parse("2024-02-06T04:53:55"), LocalDateTime.parse("2022-09-21T16:50:21"), "enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit mattis. Cras eget", "Southwell", 5L));
                eventService.saveEvent(new Event("Event Alana", LocalDateTime.parse("2023-09-10T16:14:58"), LocalDateTime.parse("2022-04-10T16:35:30"), "Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna", "Leicester", 8L));
                eventService.saveEvent(new Event("Event Blaze", LocalDateTime.parse("2023-09-12T16:46:42"), LocalDateTime.parse("2023-05-16T22:25:14"), "non, cursus", "Friedrichshafen", 15L));
                eventService.saveEvent(new Event("Event Blythe", LocalDateTime.parse("2022-09-20T21:52:13"), LocalDateTime.parse("2022-08-21T21:31:05"), "hendrerit neque. In ornare sagittis felis. Donec tempor, est ac mattis semper, dui", "Niort", 6L));
                eventService.saveEvent(new Event("Event Kuame", LocalDateTime.parse("2024-02-24T04:26:12"), LocalDateTime.parse("2023-12-08T09:12:20"), "Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis", "Vierzon", 15L));
                eventService.saveEvent(new Event("Event Cara", LocalDateTime.parse("2022-11-29T12:03:12"), LocalDateTime.parse("2023-07-12T03:54:26"), "semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum", "Uppingham. Cottesmore", 7L));
                eventService.saveEvent(new Event("Event Ashton", LocalDateTime.parse("2023-09-01T22:55:44"), LocalDateTime.parse("2024-02-01T22:04:29"), "Proin non massa non ante bibendum ullamcorper. Duis cursus, diam", "Griesheim", 6L));
                eventService.saveEvent(new Event("Event Dalton", LocalDateTime.parse("2023-03-14T20:51:41"), LocalDateTime.parse("2022-06-29T13:43:47"), "Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit", "Brive-la-Gaillarde", 8L));
                eventService.saveEvent(new Event("Event Maris", LocalDateTime.parse("2022-05-03T15:06:30"), LocalDateTime.parse("2023-08-17T02:20:20"), "rutrum urna, nec luctus felis purus ac tellus. Suspendisse sed dolor. Fusce mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit", "Berwick-upon-Tweed", 9L));
                eventService.saveEvent(new Event("Event Paul", LocalDateTime.parse("2023-10-09T07:16:20"), LocalDateTime.parse("2023-03-10T22:07:40"), "sit amet ornare lectus justo eu arcu.", "Portree", 11L));
                eventService.saveEvent(new Event("Event Keith", LocalDateTime.parse("2022-06-24T16:12:24"), LocalDateTime.parse("2023-03-01T12:48:35"), "interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus", "Lens", 14L));
                eventService.saveEvent(new Event("Event Chandler", LocalDateTime.parse("2022-12-13T04:00:53"), LocalDateTime.parse("2024-03-16T13:55:08"), "venenatis vel, faucibus id,", "Winchester", 8L));
                eventService.saveEvent(new Event("Event Galena", LocalDateTime.parse("2022-09-26T21:58:19"), LocalDateTime.parse("2024-01-10T02:51:09"), "Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue", "Maintal", 2L));
                eventService.saveEvent(new Event("Event Ocean", LocalDateTime.parse("2022-11-10T13:23:31"), LocalDateTime.parse("2023-07-02T19:05:19"), "augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam", "Avignon", 3L));
                eventService.saveEvent(new Event("Event Jillian", LocalDateTime.parse("2023-06-20T07:14:46"), LocalDateTime.parse("2023-04-05T15:15:27"), "ipsum leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla", "Draguignan", 6L));
                eventService.saveEvent(new Event("Event Abraham", LocalDateTime.parse("2022-04-12T00:16:46"), LocalDateTime.parse("2023-02-11T20:43:31"), "Cras vehicula aliquet libero. Integer in magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet lectus quis massa. Mauris vestibulum,", "Rodez", 9L));
                eventService.saveEvent(new Event("Event Iona", LocalDateTime.parse("2023-04-02T15:29:36"), LocalDateTime.parse("2023-06-26T09:26:38"), "Donec sollicitudin adipiscing", "Kirkby Lonsdale", 14L));
                eventService.saveEvent(new Event("Event Hiram", LocalDateTime.parse("2023-09-02T15:51:01"), LocalDateTime.parse("2022-11-05T09:24:26"), "Quisque nonummy ipsum non arcu. Vivamus sit amet risus.", "Cádiz", 12L));
                eventService.saveEvent(new Event("Event Ella", LocalDateTime.parse("2022-06-01T04:11:59"), LocalDateTime.parse("2023-08-06T03:06:52"), "magna. Ut tincidunt orci quis lectus. Nullam suscipit,", "Le Puy-en-Velay", 7L));
                eventService.saveEvent(new Event("Event Madaline", LocalDateTime.parse("2023-05-22T15:58:03"), LocalDateTime.parse("2024-01-01T20:19:10"), "ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae,", "Yeovil", 7L));
                eventService.saveEvent(new Event("Event Clarke", LocalDateTime.parse("2022-05-25T10:35:56"), LocalDateTime.parse("2023-01-15T20:31:59"), "Donec dignissim magna a tortor. Nunc commodo", "Logroño", 6L));
                eventService.saveEvent(new Event("Event Arsenio", LocalDateTime.parse("2022-07-15T23:56:16"), LocalDateTime.parse("2023-01-13T20:37:40"), "Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam", "Donosti", 5L));
                eventService.saveEvent(new Event("Event Juliet", LocalDateTime.parse("2023-01-30T11:49:22"), LocalDateTime.parse("2022-07-19T13:54:20"), "auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat.", "Kilmalcolm", 1L));
                eventService.saveEvent(new Event("Event Travis", LocalDateTime.parse("2022-07-27T07:00:15"), LocalDateTime.parse("2022-10-09T08:55:00"), "metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper", "Koblenz", 6L));
                eventService.saveEvent(new Event("Event Porter", LocalDateTime.parse("2022-06-17T11:11:08"), LocalDateTime.parse("2023-05-20T21:03:25"), "ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo", "Mulhouse", 8L));
                eventService.saveEvent(new Event("Event Howard", LocalDateTime.parse("2023-11-24T17:50:09"), LocalDateTime.parse("2024-01-01T23:12:12"), "Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum", "Bitterfeld-Wolfen", 10L));
                eventService.saveEvent(new Event("Event Harriet", LocalDateTime.parse("2023-10-27T07:05:54"), LocalDateTime.parse("2023-12-04T23:30:06"), "Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu.", "Alençon", 7L));
                eventService.saveEvent(new Event("Event Scarlet", LocalDateTime.parse("2022-12-03T22:29:04"), LocalDateTime.parse("2022-08-04T16:55:37"), "sodales elit erat vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla", "Kinross", 3L));
                eventService.saveEvent(new Event("Event Camilla", LocalDateTime.parse("2024-02-08T17:41:53"), LocalDateTime.parse("2023-11-07T08:42:12"), "tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede", "Wismar", 14L));
                eventService.saveEvent(new Event("Event Simon", LocalDateTime.parse("2022-12-10T21:28:21"), LocalDateTime.parse("2023-06-08T22:55:05"), "nec, malesuada ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris", "Elmshorn", 11L));
                eventService.saveEvent(new Event("Event Connor", LocalDateTime.parse("2023-01-09T21:15:03"), LocalDateTime.parse("2023-05-26T02:08:24"), "neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus vestibulum lorem,", "Wolfsburg", 15L));
                eventService.saveEvent(new Event("Event Brendan", LocalDateTime.parse("2023-02-22T20:16:39"), LocalDateTime.parse("2023-10-25T19:21:01"), "tristique senectus et netus et malesuada fames", "Nice", 1L));
                eventService.saveEvent(new Event("Event Minerva", LocalDateTime.parse("2023-05-31T13:00:00"), LocalDateTime.parse("2022-05-06T17:48:04"), "Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu", "Alacant", 2L));
                eventService.saveEvent(new Event("Event Xenos", LocalDateTime.parse("2023-06-25T04:15:05"), LocalDateTime.parse("2023-12-28T22:21:02"), "Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a,", "Reading", 13L));
                eventService.saveEvent(new Event("Event Mollie", LocalDateTime.parse("2023-08-21T15:18:28"), LocalDateTime.parse("2022-03-28T12:38:50"), "metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare", "Mâcon", 14L));
                eventService.saveEvent(new Event("Event Deacon", LocalDateTime.parse("2024-03-20T03:16:15"), LocalDateTime.parse("2023-08-12T12:41:01"), "eget magna. Suspendisse", "Wolverhampton", 11L));
                eventService.saveEvent(new Event("Event Alvin", LocalDateTime.parse("2022-06-11T05:50:58"), LocalDateTime.parse("2022-08-27T23:05:18"), "natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin", "Gloucester", 10L));
                eventService.saveEvent(new Event("Event Renee", LocalDateTime.parse("2022-10-10T20:03:32"), LocalDateTime.parse("2022-12-23T20:18:30"), "primis in faucibus orci luctus et ultrices", "Tranent", 8L));
                eventService.saveEvent(new Event("Event Tyler", LocalDateTime.parse("2023-04-10T22:13:17"), LocalDateTime.parse("2022-06-03T11:49:03"), "et risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi", "Oldenburg", 8L));
                eventService.saveEvent(new Event("Event Emma", LocalDateTime.parse("2023-11-09T19:52:39"), LocalDateTime.parse("2024-02-13T00:49:19"), "justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel,", "Bremerhaven", 5L));
                eventService.saveEvent(new Event("Event Caesar", LocalDateTime.parse("2023-07-28T00:44:52"), LocalDateTime.parse("2023-11-16T23:39:10"), "velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla", "Melilla", 9L));
                eventService.saveEvent(new Event("Event Harriet", LocalDateTime.parse("2022-12-28T07:29:11"), LocalDateTime.parse("2022-10-27T08:18:29"), "ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit", "Berlin", 6L));
                eventService.saveEvent(new Event("Event Maite", LocalDateTime.parse("2023-07-09T11:00:28"), LocalDateTime.parse("2023-04-09T21:00:42"), "euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer", "Pirna", 4L));
                eventService.saveEvent(new Event("Event Zorita", LocalDateTime.parse("2023-04-26T14:14:25"), LocalDateTime.parse("2022-11-19T20:44:19"), "et, euismod et, commodo at, libero. Morbi", "Santander", 6L));
                eventService.saveEvent(new Event("Event Lilah", LocalDateTime.parse("2022-06-07T00:29:42"), LocalDateTime.parse("2024-01-08T06:33:17"), "Nullam lobortis quam a", "Göppingen", 10L));
                eventService.saveEvent(new Event("Event Burton", LocalDateTime.parse("2024-02-24T12:28:21"), LocalDateTime.parse("2023-05-06T15:11:33"), "vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam auctor, velit eget laoreet posuere, enim", "Laurencekirk", 2L));
                eventService.saveEvent(new Event("Event Kadeem", LocalDateTime.parse("2022-09-14T12:51:24"), LocalDateTime.parse("2023-09-11T17:39:31"), "Donec sollicitudin adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra.", "Blois", 5L));
                eventService.saveEvent(new Event("Event Ivana", LocalDateTime.parse("2022-12-24T20:46:50"), LocalDateTime.parse("2023-11-17T19:30:18"), "elit. Aliquam auctor, velit eget laoreet posuere, enim nisl", "León", 3L));
                eventService.saveEvent(new Event("Event Marny", LocalDateTime.parse("2022-11-02T06:55:21"), LocalDateTime.parse("2022-09-12T17:50:05"), "mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla", "Agen", 14L));
                eventService.saveEvent(new Event("Event Armando", LocalDateTime.parse("2022-07-04T13:51:36"), LocalDateTime.parse("2023-12-09T12:43:45"), "lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu,", "Parchim	City", 11L));
                eventService.saveEvent(new Event("Event Julie", LocalDateTime.parse("2023-02-13T15:41:11"), LocalDateTime.parse("2022-10-24T21:33:25"), "arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a,", "Nantes", 7L));
                eventService.saveEvent(new Event("Event Wesley", LocalDateTime.parse("2023-06-25T21:12:02"), LocalDateTime.parse("2023-12-15T11:03:07"), "cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum.", "Luckenwalde", 2L));
                eventService.saveEvent(new Event("Event Tanya", LocalDateTime.parse("2024-03-10T02:05:45"), LocalDateTime.parse("2023-12-19T21:21:06"), "Curae Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl", "Horsham", 10L));
                eventService.saveEvent(new Event("Event Abdul", LocalDateTime.parse("2023-10-05T01:10:16"), LocalDateTime.parse("2023-05-03T16:19:46"), "lobortis risus. In mi pede, nonummy ut, molestie", "Market Drayton", 12L));
                eventService.saveEvent(new Event("Event Amos", LocalDateTime.parse("2023-11-02T01:59:43"), LocalDateTime.parse("2023-01-11T06:43:52"), "Cras sed leo. Cras vehicula aliquet libero. Integer in magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est.", "Melilla", 13L));
                eventService.saveEvent(new Event("Event Joel", LocalDateTime.parse("2023-06-24T09:23:48"), LocalDateTime.parse("2024-01-27T06:30:52"), "non enim. Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a,", "Markkleeberg", 9L));
                eventService.saveEvent(new Event("Event Shaeleigh", LocalDateTime.parse("2023-02-16T03:28:20"), LocalDateTime.parse("2023-11-28T04:34:36"), "leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris.", "Clackmannan", 5L));
                eventService.saveEvent(new Event("Event Ashely", LocalDateTime.parse("2023-01-12T02:21:56"), LocalDateTime.parse("2022-05-31T05:32:45"), "nulla magna, malesuada vel, convallis in, cursus et,", "Meißen", 6L));
                eventService.saveEvent(new Event("Event Shaine", LocalDateTime.parse("2022-12-03T09:07:02"), LocalDateTime.parse("2023-08-23T22:35:14"), "Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est ac mattis semper,", "Freiberg", 1L));
                eventService.saveEvent(new Event("Event Samson", LocalDateTime.parse("2024-02-04T23:17:04"), LocalDateTime.parse("2022-05-30T06:07:12"), "Proin sed turpis nec mauris blandit mattis. Cras eget nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum.", "Hamburg", 3L));
                eventService.saveEvent(new Event("Event Kevyn", LocalDateTime.parse("2022-08-25T22:24:53"), LocalDateTime.parse("2023-08-24T20:27:27"), "vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus", "Ourense", 15L));
                eventService.saveEvent(new Event("Event Fredericka", LocalDateTime.parse("2022-06-23T04:50:05"), LocalDateTime.parse("2023-07-14T07:45:06"), "pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam.", "Radebeul", 12L));
                eventService.saveEvent(new Event("Event Cain", LocalDateTime.parse("2023-07-30T20:37:38"), LocalDateTime.parse("2022-09-27T12:33:48"), "quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam", "Stornaway", 10L));
                eventService.saveEvent(new Event("Event Dante", LocalDateTime.parse("2024-01-19T09:51:16"), LocalDateTime.parse("2023-03-09T00:43:43"), "sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus.", "Schiltigheim", 6L));
                eventService.saveEvent(new Event("Event Kuame", LocalDateTime.parse("2023-09-13T07:56:24"), LocalDateTime.parse("2022-11-19T11:29:25"), "vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices,", "Vigo", 3L));
                eventService.saveEvent(new Event("Event Amal", LocalDateTime.parse("2023-09-26T13:27:03"), LocalDateTime.parse("2023-05-28T06:44:47"), "eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque", "Prenzlau", 2L));
                eventService.saveEvent(new Event("Event Erin", LocalDateTime.parse("2023-04-06T08:33:30"), LocalDateTime.parse("2023-04-26T20:45:34"), "urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis,", "Castres", 7L));
                eventService.saveEvent(new Event("Event Savannah", LocalDateTime.parse("2023-07-29T12:13:28"), LocalDateTime.parse("2023-02-07T07:06:47"), "mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed", "Saint-Nazaire", 15L));
                eventService.saveEvent(new Event("Event Rashad", LocalDateTime.parse("2024-01-13T20:22:47"), LocalDateTime.parse("2023-04-28T02:39:09"), "adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus.", "Sulzbach", 8L));
                eventService.saveEvent(new Event("Event Serena", LocalDateTime.parse("2023-11-26T18:28:31"), LocalDateTime.parse("2022-06-12T08:24:34"), "a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus", "Lugo", 10L));
                eventService.saveEvent(new Event("Event Velma", LocalDateTime.parse("2023-07-25T10:07:38"), LocalDateTime.parse("2023-04-09T02:24:56"), "ut, pharetra sed, hendrerit a, arcu. Sed et libero.", "Antibes", 12L));
                eventService.saveEvent(new Event("Event Candace", LocalDateTime.parse("2023-04-03T13:04:54"), LocalDateTime.parse("2023-04-18T20:59:29"), "Etiam bibendum fermentum metus.", "Slough", 11L));
                eventService.saveEvent(new Event("Event Camille", LocalDateTime.parse("2023-02-26T03:32:46"), LocalDateTime.parse("2023-04-17T17:48:42"), "ultricies adipiscing, enim mi tempor lorem, eget mollis lectus pede et risus. Quisque libero lacus, varius et, euismod et,", "Badajoz", 3L));
                eventService.saveEvent(new Event("Event Charles", LocalDateTime.parse("2023-11-14T14:15:45"), LocalDateTime.parse("2023-01-18T21:04:59"), "Donec tincidunt. Donec vitae erat vel pede blandit congue. In", "Gijón", 4L));
                eventService.saveEvent(new Event("Event Jarrod", LocalDateTime.parse("2022-04-03T11:47:02"), LocalDateTime.parse("2023-04-23T20:02:23"), "mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus", "Ipswich", 5L));
                eventService.saveEvent(new Event("Event Flavia", LocalDateTime.parse("2023-08-05T13:08:44"), LocalDateTime.parse("2022-11-12T13:50:13"), "ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum", "Carcassonne", 8L));
                eventService.saveEvent(new Event("Event Todd", LocalDateTime.parse("2022-07-01T03:05:27"), LocalDateTime.parse("2023-10-06T19:14:07"), "commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper,", "Penrith", 2L));
                eventService.saveEvent(new Event("Event Unity", LocalDateTime.parse("2022-05-24T21:54:31"), LocalDateTime.parse("2022-09-25T16:13:49"), "Etiam", "Saint-Maur-des-Fossés", 1L));
                eventService.saveEvent(new Event("Event Jana", LocalDateTime.parse("2023-07-25T09:36:46"), LocalDateTime.parse("2023-03-25T12:59:22"), "egestas. Duis ac arcu. Nunc mauris. Morbi", "Hyères", 15L));
                eventService.saveEvent(new Event("Event September", LocalDateTime.parse("2022-03-28T01:59:54"), LocalDateTime.parse("2023-10-02T05:46:09"), "malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh.", "Bourges", 3L));
                eventService.saveEvent(new Event("Event Noelani", LocalDateTime.parse("2022-07-02T18:11:47"), LocalDateTime.parse("2023-04-26T19:58:52"), "sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque", "Hertford", 14L));
                eventService.saveEvent(new Event("Event Charlotte", LocalDateTime.parse("2023-08-29T23:53:39"), LocalDateTime.parse("2023-10-17T17:56:32"), "Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci", "Dover", 11L));
                eventService.saveEvent(new Event("Event Leandra", LocalDateTime.parse("2023-03-14T13:09:37"), LocalDateTime.parse("2023-04-19T18:06:17"), "nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui", "Wattrelos", 9L));
                eventService.saveEvent(new Event("Event Odysseus", LocalDateTime.parse("2022-03-29T21:37:18"), LocalDateTime.parse("2022-05-14T07:59:18"), "Nunc mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit", "Gijón", 7L));
                eventService.saveEvent(new Event("Event Jeanette", LocalDateTime.parse("2023-12-20T10:30:47"), LocalDateTime.parse("2023-12-16T20:12:25"), "ut lacus. Nulla tincidunt, neque vitae semper egestas, urna justo faucibus lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula aliquet libero. Integer in", "Milnathort", 1L));
                eventService.saveEvent(new Event("Event Asher", LocalDateTime.parse("2022-07-02T18:46:04"), LocalDateTime.parse("2023-09-06T18:49:59"), "amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est,", "Saint-Lô", 7L));
                eventService.saveEvent(new Event("Event Kasper", LocalDateTime.parse("2022-11-26T10:23:03"), LocalDateTime.parse("2023-02-22T11:03:07"), "vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis", "Barrow-in-Furness", 12L));
                eventService.saveEvent(new Event("Event Beau", LocalDateTime.parse("2023-10-15T16:39:11"), LocalDateTime.parse("2022-08-21T22:37:12"), "purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac", "Auxerre", 4L));
                eventService.saveEvent(new Event("Event Byron", LocalDateTime.parse("2023-09-29T07:02:58"), LocalDateTime.parse("2022-11-10T02:18:49"), "mus. Aenean eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed", "Vernon", 9L));
                eventService.saveEvent(new Event("Event Zane", LocalDateTime.parse("2022-06-25T19:40:36"), LocalDateTime.parse("2023-03-31T06:25:25"), "nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante.", "San Cristóbal de la Laguna", 10L));
                eventService.saveEvent(new Event("Event Dalton", LocalDateTime.parse("2023-07-21T11:13:10"), LocalDateTime.parse("2022-10-10T11:08:34"), "aliquet lobortis, nisi nibh lacinia orci, consectetuer", "Bergerac", 3L));
                eventService.saveEvent(new Event("Event Blake", LocalDateTime.parse("2023-04-15T16:09:39"), LocalDateTime.parse("2022-05-16T21:36:33"), "consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis", "Mansfield", 3L));
            }
            // Participant Hardcoded Data Insert
            {
                participantService.saveParticipant(78L, 12L);
                participantService.saveParticipant(48L, 3L);
                participantService.saveParticipant(83L, 25L);
                participantService.saveParticipant(70L, 40L);
                participantService.saveParticipant(85L, 32L);
                participantService.saveParticipant(51L, 42L);
                participantService.saveParticipant(81L, 20L);
                participantService.saveParticipant(76L, 40L);
                participantService.saveParticipant(17L, 38L);
                participantService.saveParticipant(66L, 23L);
                participantService.saveParticipant(76L, 38L);
                participantService.saveParticipant(72L, 4L);
                participantService.saveParticipant(30L, 40L);
                participantService.saveParticipant(38L, 34L);
                participantService.saveParticipant(28L, 24L);
                participantService.saveParticipant(87L, 6L);
                participantService.saveParticipant(86L, 30L);
                participantService.saveParticipant(40L, 25L);
                participantService.saveParticipant(87L, 16L);
                participantService.saveParticipant(9L, 38L);
                participantService.saveParticipant(51L, 16L);
                participantService.saveParticipant(52L, 49L);
                participantService.saveParticipant(63L, 6L);
                participantService.saveParticipant(11L, 38L);
                participantService.saveParticipant(10L, 38L);
                participantService.saveParticipant(6L, 23L);
                participantService.saveParticipant(95L, 40L);
                participantService.saveParticipant(87L, 22L);
                participantService.saveParticipant(43L, 30L);
                participantService.saveParticipant(86L, 23L);
                participantService.saveParticipant(55L, 41L);
                participantService.saveParticipant(74L, 20L);
                participantService.saveParticipant(35L, 15L);
                participantService.saveParticipant(22L, 24L);
                participantService.saveParticipant(41L, 43L);
                participantService.saveParticipant(5L, 38L);
                participantService.saveParticipant(44L, 36L);
                participantService.saveParticipant(11L, 28L);
                participantService.saveParticipant(71L, 11L);
                participantService.saveParticipant(90L, 21L);
                participantService.saveParticipant(6L, 35L);
                participantService.saveParticipant(53L, 33L);
                participantService.saveParticipant(17L, 27L);
                participantService.saveParticipant(16L, 47L);
                participantService.saveParticipant(19L, 20L);
                participantService.saveParticipant(94L, 24L);
                participantService.saveParticipant(91L, 19L);
                participantService.saveParticipant(12L, 35L);
                participantService.saveParticipant(21L, 19L);
                participantService.saveParticipant(21L, 8L);
                participantService.saveParticipant(7L, 22L);
                participantService.saveParticipant(72L, 26L);
                participantService.saveParticipant(43L, 37L);
                participantService.saveParticipant(11L, 16L);
                participantService.saveParticipant(22L, 2L);
                participantService.saveParticipant(92L, 26L);
                participantService.saveParticipant(41L, 25L);
                participantService.saveParticipant(47L, 29L);
                participantService.saveParticipant(85L, 7L);
                participantService.saveParticipant(8L, 6L);
                participantService.saveParticipant(79L, 35L);
                participantService.saveParticipant(21L, 31L);
                participantService.saveParticipant(68L, 10L);
                participantService.saveParticipant(33L, 30L);
                participantService.saveParticipant(30L, 16L);
                participantService.saveParticipant(78L, 14L);
                participantService.saveParticipant(98L, 31L);
                participantService.saveParticipant(42L, 12L);
                participantService.saveParticipant(72L, 39L);
                participantService.saveParticipant(45L, 5L);
                participantService.saveParticipant(83L, 4L);
                participantService.saveParticipant(89L, 41L);
                participantService.saveParticipant(43L, 13L);
                participantService.saveParticipant(32L, 7L);
            }
            // Consumable Hardcoded Data Insert
            {
                consumableService.saveConsumable( new Consumable("Food","Salad","et urmia borencis vensototuli pia buccina" ) );
                consumableService.saveConsumable( new Consumable("Food","Salad Vegetarian","felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed" ) );
                consumableService.saveConsumable( new Consumable("Food","Salad Oriental","felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed" ) );
                consumableService.saveConsumable( new Consumable("Food","Steaks","felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed" ) );
                consumableService.saveConsumable( new Consumable("Food","Side Dish","felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed" ) );
                consumableService.saveConsumable( new Consumable("Food","Aperitif","placerat eget, venenatis a, magna. Lorem ipsum" ) );
                consumableService.saveConsumable( new Consumable("Food","Soups","egestas blandit. Nam nulla magna, malesuada" ) );
                consumableService.saveConsumable( new Consumable("Drink","Flat Water","Etiam vestibulum massa rutrum magna. Cras convallis" ) );
                consumableService.saveConsumable( new Consumable("Drink","Sparkling Water","risus varius orci," ) );
                consumableService.saveConsumable( new Consumable("Drink","Natural Juice","eu, placerat eget, venenatis a, magna." ) );
                consumableService.saveConsumable( new Consumable("Drink","Soda","vel lectus." ) );
                consumableService.saveConsumable( new Consumable("Drink","Non-Alcoholic Cocktail","vel lectus." ) );
                consumableService.saveConsumable( new Consumable("Alcohol Drink","Bottled Beer","aliquet odio. Etiam ligula tortor, dictum eu," ) );
                consumableService.saveConsumable( new Consumable("Alcohol Drink","Draft Beer","odio semper cursus." ) );
                consumableService.saveConsumable( new Consumable("Alcohol Drink","Wine","mauris. Morbi non" ) );
                consumableService.saveConsumable( new Consumable("Alcohol Drink","Whiskey/Bourbon","nulla. Integer urna. Vivamus" ) );
                consumableService.saveConsumable( new Consumable("Alcohol Drink","Spirits","et libero. Proin mi. Aliquam" ) );
            }
        };
    }
}
