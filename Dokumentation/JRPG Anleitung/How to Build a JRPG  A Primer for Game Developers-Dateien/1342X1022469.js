/*
 Skimlinks javascript runtime
 Copyrights 2009 - 2018

 Build time: Mon, 22 Jan 2018 08:47:15 GMT
 Version: 13.1.2
*/
(function(){function ba(a){var c;a=a.target||a.srcElement;var b=null!=a?null!=(c=a.nodeName)?"function"===typeof c.toUpperCase?c.toUpperCase():void 0:void 0:void 0;"A"!==b&&"AREA"!==b&&(a=za(a));return a}function Eb(a){var c;m.event&&(a=m.event);var b=a.originalTarget||a.srcElement||a.target;var d=null!=b?b.nodeName.toUpperCase():void 0;"A"!==d&&"AREA"!==d&&(b=Fb(b));(d=!b||Gb(b))||(d=r(b,"rel"),d=!(L?L===d:!d||!Aa(d)));if(d)return!0;var e=T(b.href);d=F(b.hostname);var f="click"===a.type||"contextmenu"===
a.type;if(c=Ba)if(c=b,null===c.offsetParent)c=!0;else{var n=m.getComputedStyle;c=q(n)?"hidden"===n(c).visibility:!1}n=(n=b)&&n.href?/^https?:\/\//.test(n.href)||/^\/\//.test(n.href):!1;if(n&&ca(b.href,d)&&!c){if(Ca(d)||Hb(d))Da(b,a);else if(f&&Ea(e)&&!Fa(d))return B&&r(b,"target",B),Ib(a);return!0}}function Ga(a){var c=ba(a);if(!c)return!0;var b=c;b&&b.nodeName&&"A"!==b.nodeName.toUpperCase()&&"AREA"!==b.nodeName.toUpperCase()&&(b=za(b));if(b){var d=Jb(b);var e=l.waypointDomain;if(!(d.length>=e.length&&
d.substr(0,e.length)===e)){e=-1!==d.indexOf(e)?d:Kb(b,d);if(Ha){var f=g("pageTracker");var n="/skimout/"+d;null!=f&&f._trackPageview?f._trackPageview(n):g("_gaq")?(f=g("_gaq"),f.push(["_trackEvent","skimout","click",d])):g("ga")&&g("ga")("send","event","click","skimout",d)}Ia(b);Ja(b,e)}}b=g("skimlinks_keywee_pixel",null);e=-1<m.location.href.indexOf("utm_campaign=fbkw");b&&e&&Ka(b);g("vglnk")&&C(c,"skimwords-link")&&(a&&a.stopPropagation?a.stopPropagation():(a=m.event,a.cancelBubble=!0));return!0}
function za(a){for(;a.parentNode;){a=a.parentNode;var c=a.nodeName.toUpperCase();if("A"===c||"AREA"===c)return a}return null}function La(a,c){var b={data:w({pubcode:x,domains:a,page:m.location.href})};da(b);Lb(a,c);return!0}function Ma(){var a;var c=ea();var b=[];var d=0;for(a=c.length;d<a;d++){var e=c[d];var f=F(e.hostname);var n=T(e.href);e=r(e,"rel");!f||!ca(n,f)||(L?L!==e:e&&Aa(e))||M(f)||void 0!==l.aff_domains[f]||(b.push(f),l.domain_data.domains.push(f),l.aff_domains[f]=null)}return b}function Mb(a){return fa(a,
"beacon_callback_aux")}function Nb(a){fa(a,"beacon_callback_post_page_load");return Na()}function Ob(a){return fa(a,"beacon_callback_pre_page_load")}function Na(a){var c,b;a||(a=0);if(m.skimlinks_requests_in_flight&&5>a)setTimeout(function(){return Na(a+1)},400*a);else{var d=ea();var e=c=0;for(b=d.length;e<b;e++){var f=d[e];var n=T(f.href);var h=F(f.hostname);var g=r(f,"class");(!g||-1===g.indexOf("skimwords-link")&&-1===g.indexOf("skimlinks-unlinked"))&&ca(n,h)&&!Pb(f)&&(Ca(h)?(c++,D(k.link_impressions,
n)?k.link_impressions[n].ae=1:k.link_impressions[n]={count:0,ae:1}):D(k.link_impressions,n)||(k.link_impressions[n]={count:0,ae:0}),k.link_impressions[n].count++,f=Qb(n))&&(k.link_impressions[n].slmcid=f,0>Rb.call(k.campaign_ids,f)&&k.campaign_ids.push(f))}l.handlers=c;l.links_tracked||null==Oa||null==l.domain_data||null==l.domain_data.domains||(l.links_tracked=!0,Oa(l.domain_data.domains));Sb("skimlinks")}return!0}function Pa(a,c,b){for(null==b&&(b=!1);null!=a&&a!==l.html_root;){var d=C(a,c)||C(a,
"noskim");if(a.className&&d)return!0;a=b?null:a.parentNode}return!1}function Fa(a){null!==l.exclude_lookup&&null!==l.include_lookup||Qa();if(!a)return!1;var c=l.exclude_lookup;for(d in c)if(Ra.call(c,d)){var b=c[d];if(0===d.indexOf("*")){var d=d.substr(1);--b;var e=a.lastIndexOf(d);if(-1!==e&&e===a.length-b)return!0}else if(a===d)return!0}return!1}function Pb(a){var c=Sa.join(", ");if(!a&&!c)return!1;var b=Boolean,d;if(d=c)a:if(q(window.Element.prototype.closest))d=a.closest(c);else{for(;a&&1===a.nodeType;){d=
a;var e=c,f=window.Element.prototype;f=f.matches||f.msMatchesSelector||f.mozMatchesSelector||f.webkitMatchesSelector;if(q(f))d=f.call(d,e);else{e=Tb(d.document||d.ownerDocument,e);for(f=0;e[f]&&e[f]!==d;)f+=1;d=!!e[f]}if(d){d=a;break a}a=a.parentNode}d=null}return b(d)}function ca(a,c){var b;if(b=g("_merchantSettings"))b=-1!==c.indexOf("itunes.apple.com")||-1!==c.indexOf("itunes.com")||-1!==c.indexOf("phobos.apple.com");return b||Fa(c)?!1:Ea(a)&&Ub(c)}function Ca(a){return G?(Ta(a)&&(l.handlers+=
1),!1):Ta(a)}function Gb(a){for(var c,b,d,e,f;a&&a!==l.html_root;){d=a.id;b=0;for(e=N.length;b<e;b++)if(c=N[b],C(a,c))return!1;f=l.included_ids;b=0;for(e=f.length;b<e;b++)if(c=f[b],d===c)return!1;e=l.excluded_classes;d=0;for(b=e.length;d<b;d++)if(c=e[d],C(a,c))return!0;a=a.parentNode}return N.length||l.included_ids.length?!0:!1}function ea(a){var c=1<arguments.length&&void 0!==arguments[1]?arguments[1]:p,b=null;a&&(b=new RegExp("\\b"+Vb(a)+"\\b","i"));var d=ha(c.getElementsByTagName("a"));c=ha(c.getElementsByTagName("area"));
d=d.concat(c);return ia(d,function(a,c){c.href&&(!b||c.className&&b.test(c.className))&&a.push(c);return a},[])}function Sb(a){var c;if(!ja||Ua)return!1;k.tracking[a]=!1;a=!0;var b=k.tracking;for(c in b)if(Va.call(b,c)){var d=b[c];if(!0===d){a=!1;break}}if(a)return Ua=!0,Wb()}function Oa(){if(!ja)return!1;var a=Wa(x,m,h,l,k);a={data:w(a)};v&&(a.dnt=v);y&&(a.fdnt=1);a=da(a);if(h.isAdblockUser||!Xa("//t.skimresources.com/api/link",a,Ya))return Xb()}function Xa(a,c,b){if("msie"!==h.detect.browser){var d=
!1;var e=new XMLHttpRequest;e.open("POST",a,!0);e.setRequestHeader("Content-type","application/x-www-form-urlencoded");0<=Za.call(e,"withCredentials")&&(e.withCredentials=!0);e.async="true";e.onreadystatechange=function(){if(d)return!0;if(4===e.readyState){d=!0;if(200===e.status){var a={};var c=e.responseText;if(0===c.indexOf("//"))return b(a),!0;try{a=$a(e.responseText)}catch(Uc){}b(a);return!0}return!1}};e.send(c)}else if(m.XDomainRequest){var f=new XDomainRequest;0<=Za.call(f,"withCredentials")&&
(f.withCredentials=!0);if(f){f.open("POST",a,!0);f.onload=function(){var a={};if(0===f.responseText.indexOf("//"))return b(a),!0;try{a=$a(f.responseText)}catch(Tc){}b(a);return!0};f.onerror=function(){return!1};f.onprogress=function(){return!1};f.ontimeout=function(){return!1};f.async=!0;try{f.send(c)}catch(n){return!1}}}else return!1;return!0}function da(a){var c;var b=[];G&&(a.xrf=1);for(c in a)D(a,c)&&b.push(""+c+"="+t(a[c]));return b.join("&")}function U(a,c,b,d,e){var f;null==b&&(b={});var n=
b.charset||null;var h=b.target||null;b=null!=(f=b.async)?f:!0;f=null!=h&&h.document?h.document:document;var k=f.getElementsByTagName("head")[0];var g=f.createElement("script");g.type="text/javascript";n&&(g.charset=n);c&&(g.onload=g.onreadystatechange=function(a){return function(){var b=!1;return function(){var d=a.readyState;if(!(b||d&&"complete"!==d&&"loaded"!==d))return g.onload=g.onreadystatechange=null,b=!0,c.call(h),!0}}}(this)());g.onerror=function(){if(null!=d)return null!=e?d(e):d(!1)};g.async=
!1!==b;g.src=a;k.appendChild(g);return g}function F(a){return a.replace(/^www\./i,"")}function Yb(){for(var a=0<arguments.length&&void 0!==arguments[0]?arguments[0]:[],c=arguments[1],b=arguments[2],d=0;d<a.length;d++){var e=ab(a[d]);if(!H(e))return q(b)?b(e,c):e}return c}function ab(a,c,b){return H(m[a])?c:q(b)?b(m[a],c):m[a]}function g(a,c,b){return ka(a)?Yb(a,c,b):ab(a,c,b)}function H(a){return"undefined"===typeof a||null===a}function ka(a){return Array.isArray?Array.isArray(a):"[object Array]"===
Object.prototype.toString.call(a)}function q(a){return"[object Function]"===Object.prototype.toString.call(a)}function la(a,c){if(q(a.indexOf))return a.indexOf(c);if(ka(a))for(var b=0;b<a.length;b++)if(a[b]===c)return b;return-1}function Zb(){var a=1<arguments.length&&void 0!==arguments[1]?arguments[1]:"";return 0===la((0<arguments.length&&void 0!==arguments[0]?arguments[0]:"").slice(2<arguments.length&&void 0!==arguments[2]?arguments[2]:0),a)}function bb(){var a=0<arguments.length&&void 0!==arguments[0]?
arguments[0]:"",c=1<arguments.length&&void 0!==arguments[1]?arguments[1]:"",b=2<arguments.length&&void 0!==arguments[2]?arguments[2]:0;b=b<a.length?b|0:a.length;return a.substr(b-c.length,c.length)===c}function V(a){var c=1<arguments.length&&void 0!==arguments[1]?arguments[1]:!0,b=p.createElement("a");b.href=c?a:$b(a);try{return F(b.hostname)}catch(d){return""}}function $b(a){var c=1<arguments.length&&void 0!==arguments[1]?arguments[1]:"http",b="";/^https?:\/\//.test(a)||/^\/[^/]+/.test(a)||(b=/^\/\//.test(a)?
c+":":c+"://");return""+b+a}function Ea(a){var c=V(a,1<arguments.length&&void 0!==arguments[1]?arguments[1]:!0),b=l.hostname,d=bb(c,"."+b)||bb(b,"."+c);return c!==b&&!d}function cb(a){return ma?ma:"msie"===h.detect.browser&&8>=h.detect.version||a?"//go.redirectingat.com":"//go.skimresources.com"}function M(a){return-1!==l.waypointDomain.indexOf(a)||-1!==a.indexOf("go.redirectingat.com")||-1!==a.indexOf("go.skimresources.com")}function D(a,c){return Object.prototype.hasOwnProperty.call(a,c)}function O(a){return 10>
a?"0"+a:""+a}function na(){return this.valueOf()}function oa(a){pa.lastIndex=0;return pa.test(a)?'"'+a.replace(pa,function(a){var b=db[a];return"string"===typeof b?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+a+'"'}function W(a,c){var b,d=void 0,e=u,f=c[a];f&&"object"===typeof f&&q(f.toJSON)&&(f=f.toJSON(a));q(z)&&(f=z.call(c,a,f));switch(typeof f){case "string":return oa(f);case "number":return isFinite(f)?String(f):"null";case "boolean":case "null":return String(f);case "object":if(!f)return"null";
u+=X;var n=[];if(ka(f)){var h=f.length;for(b=0;b<h;b+=1)n[b]=W(b,f)||"null";var g=0===n.length?"[]":u?"[\n"+u+n.join(",\n"+u)+"\n"+e+"]":"["+n.join(",")+"]";u=e;return g}if(z&&"object"===typeof z)for(h=z.length,b=0;b<h;b+=1)"string"===typeof z[b]&&(d=z[b],(g=W(d,f))&&n.push(oa(d)+(u?": ":":")+g));else for(d in f)D(f,d)&&(g=W(d,f))&&n.push(oa(d)+(u?": ":":")+g);g=0===n.length?"{}":u?"{\n"+u+n.join(",\n"+u)+"\n"+e+"}":"{"+n.join(",")+"}";u=e;return g}}function w(a,c,b){if(window.JSON&&q(JSON.stringify))return JSON.stringify.apply(null,
arguments);eb();var d;X=u="";if("number"===typeof b)for(d=0;d<b;d+=1)X+=" ";else"string"===typeof b&&(X=b);if((z=c)&&!q(c)&&("object"!==typeof c||"number"!==typeof c.length))throw Error("JSON.stringify");return W("",{"":a})}function $a(a,c){function b(a,d){var e=void 0,f=a[d];if(f&&"object"===typeof f)for(e in f)if(D(f,e)){var g=b(f,e);void 0!==g?f[e]=g:delete f[e]}return c.call(a,d,f)}if(window.JSON&&q(JSON.parse))return JSON.parse.apply(null,arguments);eb();var d=void 0;a=String(a);qa.lastIndex=
0;qa.test(a)&&(a=a.replace(qa,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)}));if(ac.test(a.replace(bc,"@").replace(cc,"]").replace(dc,"")))return d=(0,eval)("("+a+")"),q(c)?b({"":d},""):d;throw new SyntaxError("JSON.parse");}function ec(a){a.width=0;a.height=0;a.style.display="none"}function fb(){return(0<arguments.length&&void 0!==arguments[0]?arguments[0]:p).getElementsByTagName("body")[0]}function Ka(a,c){I||(I=p.createElement("iframe"),fb().appendChild(I),ec(I));var b=
I.contentDocument||I.contentWindow.document,d=fb(b);d||(d=p.createElement("body"),b.appendChild(d));b=b.createElement("img");b.src=a;b.width=1;b.height=1;c&&q(c)&&(b.onload=function(){c()});d.appendChild(b)}function ra(a,c){for(var b=0;b<a.length;b++)c(a[b],b,a)}function T(a){return H(a)?"":a.toString().replace(/^[\s\xA0]+|[\s\xA0]+$/g,"")}function r(a,c,b){3<=arguments.length&&("undefined"!==typeof a.setAttribute?a.setAttribute(c,b):a[c]=b);try{var d=a[c];d||(d=a.getAttribute(c));return d}catch(e){return null}}
function Wa(a,c,b,d,e){return{dl:e.link_impressions,guid:b.cookie,hae:d.handlers?1:0,pag:c.location.href,pub:a,sessid:b.sessid,slmcid:e.campaign_ids,typ:"l",tz:b.timezone,uuid:b.uuid}}function ia(a,c,b){for(var d=0,e=null===a?0:a.length;d<e;)b=c(b,a[d],d,a),d+=1;return b}function ha(a){return ia(a,function(a,b){return a.concat(b)},[])}function gb(a,c){var b=2<arguments.length&&void 0!==arguments[2]?arguments[2]:!1,d=document.createElement("div"),e="qsa"+String(Math.random()).slice(3);d.innerHTML=
"x<style>"+c+"{qsa:"+e+";}";d=hb.appendChild(d.lastChild);e=ib(a,c,b,e);hb.removeChild(d);return b?e[0]:e}function ib(a,c,b,d){var e=/1|9/.test(a.nodeType),f=a.childNodes,g=[],h=0;if(e&&a.currentStyle&&a.currentStyle.qsa===d&&g.push(a)&&b)return g;for(;(a=f[h])&&(g=g.concat(ib(a,c,b,d)),h+=1,!b||!g.length););return g}function Tb(a,c){1===arguments.length&&"string"===typeof a&&(c=a,a=p);return q(a.querySelectorAll)?ha(a.querySelectorAll(c)):gb(a,c,!1)}function C(a,c){return a&&a.className&&c?0<=la(T(a.className).split(/\s+/),
c):!1}function fc(a,c){var b=!1,d=void 0;return function(){if(b)return d;setTimeout(function(){b=!1},c);b=!0;return d=a.apply(this,arguments)}}function Ja(a,c){if(a){var b=null,d=a.childNodes.length&&3===a.childNodes[0].nodeType;"msie"===h.detect.browser&&d&&(b=a.innerHTML);a.href=c;b&&b!==a.innerHTML&&(a.innerHTML=b)}}function Ia(a){if(!a||!a.sl_href_restore_scheduled){var c=a.href,b="msie"===h.detect.browser&&7>h.detect.version?1E4:jb;a.sl_href_restore_scheduled=!0;setTimeout(function(){a.href=
c;delete a.sl_href_restore_scheduled},b)}}function kb(a,c){J||1E3<c?q(a)&&(J?sa?a(!0):a(!1):a(!1)):setTimeout(kb,c*=2,a,c)}function lb(){J||(P.complete&&Q.complete&&(J=!0),J&&"0"!=P.width&&"0"==Q.width&&(sa=!0))}function gc(a,c){1===arguments.length&&"string"===typeof a&&(c=a,a=p);return q(a.querySelector)?a.querySelector(c):gb(a,c,!0)}function hc(a,c){return-1!==la(a,c)}function ic(a,c){if(!a)return[];if(!c)return[].concat(a);var b=[];ra(a,function(d,e){b.push(c(d,e,a))});return b}function jc(a){function c(a){return a.toLowerCase().replace(/^\/\/|^https?:\/\//,
"")}var b=ic(mb,c);return hc(b,c(a))}function kc(a){if(H(a))return[];var c=[],b;for(b in a)D(a,b)&&c.push(b);return c}function lc(){var a=arguments[0],c=Array.prototype.slice.call(arguments,1);H(a)&&(a={});ra(c,function(b){H(b)&&(b={});ia(kc(b),function(a,c){a[c]=b[c];return a},a)});return a}function mc(){return{skimOptions:nc,runTimeInfo:lc({},{aff_domains:l.aff_domains},h)}}var nb=window.skimlinks_context_window||null,m=nb?window[nb]:window,p=m.document,oc=[].indexOf||
function(a){for(var c=0,b=this.length;c<b;c++)if(c in this&&this[c]===a)return c;return-1},K={topics:{},on:function(a,c){var b;null==(b=this.topics)[a]&&(b[a]=[]);return this.topics[a].push(c)},off:function(a,c){var b=0<=oc.call(this.topics[a],c);if(-1<b)return this.topics[a].splice(b,1)},once:function(a,c){var b=function(a){return function(){b.called||c.apply(a,arguments);return b.called=!0}}(this);b.called=!1;return this.on(a,b)},publish:function(a,c){var b;var d={topic:a,extra:c};if(this.topics[a]){var e=
this.topics[a];var f=[];var g=0;for(b=e.length;g<b;g++){var h=e[g];f.push("function"===typeof h?h(d):void 0)}return f}}},pc="*.g.doubleclick.net *mjxads.internet.com *pgpartner.co.uk *pgpartner.com *pricegrabber.co.uk *pricegrabber.com *overture.com *youtube.com paid.outbrain.com trc.taboola.com traffic.outbrain.com zergnet.com *.criteo.com track.celtra.com".split(" "),ta=/https?:/g;p.createTextNode("");var qc=["noskim","norewrite"],ua={"t.umblr.com":{name:"z"}},x="1342X1022469",ob="1022469",
va=g("noskim",!1),rc=g("noskimlinks",!1),sc=g("noskimwords",!0),tc=g("nounlinked",!0),uc=g("skimwords_standard",false),vc=g("skimwords_lite",false),wc=g("skimwords_diy",false),xc=g("skimwords_diy_filter",false),pb=!va&&!rc,qb=!va&&!sc,rb=!va&&!tc,v=g("skimlinks_dnt",0,function(a){return a&&"0"!==a&&"false"!==a?1:0}),y=g("skimlinks_nocookie",!1),N=g("skimlinks_included_classes",[]),
sb=g("skimlinks_excluded_classes",[]),tb=g("skimlinks_exclude",["graphicriver.net"]),ub=g("skimlinks_include",[]),vb=g("skimlinks_included_ids",[]),wa=g("skimlinks_exrel",""),L=g("skimlinks_byrel",!1),Ba=g("skimlinks_ignore_hidden_links",false),Sa=g("skimlinks_link_impression_exclude_selector",[]),
wb=g("skimlinks_add_nofollow",false),xb=g("skimlinks_before_click_handler",false,function(a,c){return"boolean"!==typeof a?c:a}),yb=g("skimlinks_first_party_na",!1),yc=g("skimlinks_cookie_sync_optout",!0),ja=!g("noimpressions",!1),jb=g("skimlinks_replace_timeout",300,function(a,c){var b=parseFloat(a);return isNaN(b)?c:b}),zb=g("skimlinks_affiliate_unknown_links",true),
B=g("skimlinks_target",null),zc=g("skimlinks_ajax_rerun",false),R=g("sl_test",!1),G=g("skimlinks_revenue_forecast",false),Ac=g("skimlinks_noright",false),Ab=g("skimlinks_url_extraction_rules",!1)||false,xa=g("skimlinks_extra_redir_params",[]).join("&"),Y=g(["affiliate_tracking","skimlinks_tracking"],!1,function(a,c){var b=/^[a-z0-9_\\|]+$/i;
return a&&b.test(a)?a:c}),Z=g("force_location"),A=g(["skimlinks_site","skimlinks_sitename"],!1),Bb=g("skimlinks_domain",""),ma=Bb?"http://"+Bb:"",Ha=g("skimlinks_google",false),mb=g("noskim_domains",[]),Bc=g("skimwords_horizontal_distance",80),Cc=g("skimwords_vertical_distance",80),Cb=g("skimlinks_profiling",false),Dc=g("skimwords_color",
null),Ec=g("skimwords_weight",null),Fc=g("skimwords_decoration",null),Gc=g("skimwords_style",null),Hc=g("skimwords_title",null),ya=g("no_skim_selector",""),nc=Object.freeze({SW_STANDARD:uc,SW_LITE:vc,SW_DIY:wc,SW_DIY_FILTER:xc,HAS_SKIMLINKS:pb,HAS_SKIMWORDS:qb,HAS_UNLINKED:rb,DO_NOT_TRACK:v,NO_COOKIE:y,SL_INCLUDED_CLASSES:N,
SL_EXCLUDED_CLASSES:sb,SL_EXCLUDED_DOMAINS:tb,SL_INCLUDED_DOMAINS:ub,SL_INCLUDED_IDS:vb,SL_EXCLUDED_REL:wa,SL_INCLUDED_REL:L,SL_IGNORE_HIDDEN_LINKS:Ba,SL_IMPRESSION_EXCLUDED_SELECTORS:Sa,SL_ADD_NOFOLLOW:wb,SL_BEFORE_CLICK_HANDLER:xb,SL_FIRST_PARTY_NA:yb,SL_COOKIE_SYNC_OPTOUT:yc,SL_TRACK_IMPRESSION:ja,SL_REPLACE_TIMEOUT:jb,SL_AFFILIATE_UNKNOWN_LINKS:zb,SL_TARGET:B,AJAX_SUPPORT:zc,SL_TEST:R,UNLINKED_EXCLUDES:[],SL_FORECAST:G,NO_RIGHT_CLICK:Ac,USE_MERCHANT_URL_EXTRACTION_RULES:Ab,EXTRA_REDIR_PARAMS:xa,
CUSTOM_TRACKING_VAR:Y,FORCE_LOCATION:Z,SITE_NAME:A,CUSTOM_WAYPOINT_DOMAIN:ma,TRACKING_GOOGLE:Ha,NO_SKIM_DOMAINS:mb,SW_HORIZONTAL_DISTANCE:Bc,SW_VERTICAL_DISTANCE:Cc,SL_PROFILING:Cb,SW_LINK_COLOR:Dc,SW_LINK_WEIGHT:Ec,SW_LINK_DECORATION:Fc,SW_LINK_STYLE:Gc,SW_LINK_TITLE:Hc,NO_SKIM_SELECTOR:ya}),h=function(){var a=p.referrer||document.referrer||"",c=Z||m.location.href;var b="aspsession-id aspsessionid cftoken j-sessionid jsessid jsession_id jsessionid phpsessid phpsession-id phpsessionid seskey sessid session-id session-key session_id sessionid sessionkey uniqueid utm_campaign utm_medium utm_source utm_term".split(" ");
for(var d=0;d<b.length;d++){var e=b[d];var f=c.split("?");if(2<=f.length){c=f.shift();f=f.join("?");e=encodeURIComponent(e)+"=";f=f.split(/[&;]/gi);for(var g=f.length-1;0<=g;g--)Zb(f[g],e)&&f.splice(g,1);c=c+"?"+f.join("&")}}"?"===c[c.length-1]&&(c=c.substr(0,c.length-1));b=c;d=navigator.userAgent.toLowerCase();d=/(webkit)[ /]([\w.]+)/.exec(d)||/(opera)(?:.*version)?[ /]([\w.]+)/.exec(d)||/(msie) ([\w.]+)/.exec(d)||0>d.indexOf("compatible")&&/(mozilla)(?:.*? rv:([\w.]+))?/.exec(d)||[];d={browser:d[1]||
"",version:parseFloat(d[2])||0};c=(new Date).getTimezoneOffset();e="";for(f=0;8>f;f++)e+=Math.floor(65536*(1+Math.random())).toString(16).substring(1);return{cookie:"",detect:d,isAdblockUser:!1,pageLocation:b,referrer:a,sessid:"",timezone:c,uuid:e,skimwordsEnabled:qb,skimlinksEnabled:pb,unlinkedEnabled:rb}}(),k={campaign_ids:[],impressions:{pag:"",phr:[],unl:[],pub:x,slc:0,swc:0,ulc:0,jsl:0,jsf:"",guid:"",uuid:"",sessid:"",uc:Y,t:1,slmcid:!1},link_impressions:{},loading_started:(new Date).getTime(),
phrase_impressions:[],tracking:{skimlinks:!1,skimwords:!1,unlinked:!1},unlinked_impressions:[]},l=function(){var a=document.getElementsByTagName("html")?document.getElementsByTagName("html")[0]:null,c=Z?V(Z,!1):m.location.hostname;return{aff_domains:{},beacon:[],callback_name:"skimlinksBeaconCallback",domain_data:{domains:[]},exclude:tb,exclude_lookup:null,excluded_classes:["noskimlinks","noskim"].concat(sb),handlers:0,has_been_called:!1,hostname:c,html_root:a,include:ub,include_lookup:null,included_classes:N,
included_ids:vb,links:[],links_tracked:!1,target:null,waypointDomain:cb()}}(),ac=/^[\],:{}\s]*$/,bc=/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,cc=/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,dc=/(?:^|:|,)(?:\s*\[)+/g,pa=/[\\"\u0000-\u001f\u007f-\u009f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,qa=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,eb=function(a){var c=!1,
b=void 0;return function(){if(c)return b;b=a.apply(this,arguments);c=!0;return b}}(function(){q(Date.prototype.toJSON)||(Date.prototype.toJSON=function(){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+O(this.getUTCMonth()+1)+"-"+O(this.getUTCDate())+"T"+O(this.getUTCHours())+":"+O(this.getUTCMinutes())+":"+O(this.getUTCSeconds())+"Z":null});q(Boolean.prototype.toJSON)||(Boolean.prototype.toJSON=na);q(Number.prototype.toJSON)||(Number.prototype.toJSON=na);q(String.prototype.toJSON)||(String.prototype.toJSON=
na)}),u=void 0,X=void 0,db=void 0,z=void 0;db={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"};var Za=[].indexOf||function(a){for(var c=0,b=this.length;c<b;c++)if(c in this&&this[c]===a)return c;return-1},t=function(){var a;var c=[function(){var b;var c=[["%20","+"],["!","%21"],["'","%27"],["\\(","%28"],["\\)","%29"],["\\*","%2A"],["\\~","%7E"]];var e=[];var f=0;for(b=c.length;f<b;f++)a=c[f],e.push([new RegExp(a[0],"g"),a[1]]);return e}()];return function(b){var d;var e=
encodeURIComponent(b);b=0;for(d=c.length;b<d;b++)a=c[b],e=e.replace(a[0],a[1]);return e}}(),I=void 0,Va={}.hasOwnProperty;var Ua=!1;var Xb=function(){var a;var c=8E3;"msie"===h.detect.browser&&(c=2E3);var b=Wa(x,m,h,l,k);b.dl={};var d="//t.skimresources.com/api/link?data=";var e=0;var f=k.link_impressions;for(a in f)if(Va.call(f,a)){var g=f[a];e++;b.dl[a]=g;g=d+t(w(b));g.length>c&&(e--,delete b.dl[a])}e&&(d+=t(w(b)),U(d,!1,{async:!0}));return!0};var Ya=function(){return!0};var aa=function(a){var c,
b;if(a instanceof Array){var d={};var e=c=0;for(b=a.length;c<b;e=++c){var f=a[e];d[""+e]=f}return d}return a};var Ic=function(){var a,c;var b=(new Date).getTime()-k.loading_started;var d=8E3;"msie"===h.detect.browser&&(d=2E3);k.impressions.tz=h.timezone;k.impressions.slc=l.handlers;k.impressions.swc=0;k.impressions.ulc=0;k.impressions.jsl=b;k.impressions.guid=h.cookie;k.impressions.slmcid=k.campaign_ids;k.impressions.uuid=h.uuid;k.impressions.sessid=h.sessid;k.impressions.pref=h.referrer;k.impressions.phr=
[];k.impressions.unl=[];G&&(k.impressions.xrf=1);b="//t.skimresources.com/api/track.php?";v&&(b+="dnt=1&");y&&(b+="fdnt=1&");h.isAdblockUser&&(b+="abp=1&");b+="data=";var e=k.phrase_impressions;var f=a=0;for(c=e.length;a<c;f=++a)f=e[f],k.impressions.phr.push(f),f=b+t(w(k.impressions).replace(ta,"")),f.length>d&&(k.impressions.phr=k.impressions.phr.slice(0,-1));e=k.unlinked_impressions;f=a=0;for(c=e.length;a<c;f=++a)f=e[f],k.impressions.unl.push(f),f=b+t(w(k.impressions).replace(ta,"")),f.length>d&&
(k.impressions.unl=k.impressions.unl.slice(0,-1));k.impressions.phr=aa(k.impressions.phr);k.impressions.unl=aa(k.impressions.unl);d=b+t(w(k.impressions).replace(ta,""));return U(d,!1,{async:!0})};var Wb=function(){var a=(new Date).getTime()-k.loading_started;k.impressions.tz=h.timezone;k.impressions.slc=l.handlers;k.impressions.swc=0;k.impressions.ulc=0;k.impressions.jsl=a;k.impressions.guid=h.cookie;k.impressions.slmcid=k.campaign_ids;k.impressions.uuid=h.uuid;k.impressions.sessid=h.sessid;k.impressions.pref=
h.referrer;k.impressions.pag=h.pageLocation;k.impressions.phr=aa(k.phrase_impressions);k.impressions.unl=aa(k.unlinked_impressions);a={data:w(k.impressions)};v&&(a.dnt=v);y&&(a.fdnt=1);a=da(a);!h.isAdblockUser&&Xa("//t.skimresources.com/api/track.php",a,Ya)||Ic();return!0};K.on("skim_js_init",function(){k.tracking.skimlinks=h.skimlinksEnabled;k.tracking.skimwords=h.skimwordsEnabled;return k.tracking.unlinked=h.unlinkedEnabled});var Vb=function(){var a=/[-[\]{}()*+?.,\\^$|#]/g,c=/\s+/g;return function(b){return b.replace(a,
"\\$&").replace(c,"\\s+")}}(),hb=p.getElementsByTagName("head")[0],Ra={}.hasOwnProperty,Jc=[].indexOf||function(a){for(var c=0,b=this.length;c<b;c++)if(c in this&&this[c]===a)return c;return-1};var Qa=function(){var a;l.exclude_lookup={};l.include_lookup={};A&&l.exclude.push(A);var c=l.exclude.concat(pc);var b=0;for(a=c.length;b<a;b++){var d=c[b];l.exclude_lookup[d]=d.length}c=l.include;b=0;for(a=c.length;b<a;b++)d=c[b],l.include_lookup[d]=d.length;return l.exclude_lookup};var Ub=function(a){null!==
l.exclude_lookup&&null!==l.include_lookup||Qa();if(!a)return!1;if(0===l.include.length)return!0;var c=l.include_lookup;for(e in c)if(Ra.call(c,e)){var b="*"===e.substr(0,1);var d="*"===e.substr(e.length-1,1);var e=e.replace(/\*/g,"");if(b&&d){if(-1!==a.indexOf(e))return!0}else if(b){if(-1!==a.indexOf(e)&&a.indexOf(e)===a.length-e.length)return!0}else if(d){if(0===a.indexOf(e))return!0}else if(a===e)return!0}return!1};var Ta=function(a){return!0===l.aff_domains[a]||(null===l.aff_domains[a]||void 0===
l.aff_domains[a])&&zb&&!M(a)};var Aa=function(a){var c;if(!a)return!1;var b=a.toLowerCase().split(/\s+/);a=wa?[wa.toLowerCase()]:[];a=a.concat(qc);var d=0;for(c=b.length;d<c;d++){var e=b[d];if(0<=Jc.call(a,e))return!0}return!1};var Rb=[].indexOf||function(a){for(var c=0,b=this.length;c<b;c++)if(c in this&&this[c]===a)return c;return-1};var Qb=function(a){return-1===a.indexOf("#slm-")||(a=a.split("#slm-"),2!==a.length||isNaN(a[1])||10*parseInt(a[1])!==10*a[1])?null:parseInt(a[1])};var fa=function(a,
c){var b;--m.skimlinks_requests_in_flight;var d=null!=a?a:{};a&&(l.beacon.push(d),K.publish("beacon",d));d.guid&&""===h.cookie&&(h.cookie=d.guid);d.sessid&&""===h.sessid&&(h.sessid=d.sessid);l.waypointDomain=cb(h.cookie);var e=d.merchant_domains||[];var f=0;for(b=e.length;f<b;f++){var g=e[f];M(g)||(l.aff_domains[g]=!0)}for(g in l.aff_domains)null===l.aff_domains[g]&&(l.aff_domains[g]=!1);Cb&&(g=h.cookie,ob&&g&&U("https://o.skimresources.com/"+ob+"/profile/"+g+"?callback=skimlinksODPCallback",!1,{}));
if(wb)for(e=ea(),g=0,f=e.length;g<f;g++)b=e[g],Kc(b);return K.publish(c,d)};var Kc=function(a){var c=r(a,"rel");var b=F(a.hostname);if(!c&&b&&!0===l.aff_domains[b])return r(a,"rel","nofollow")};m.skimlinksODPCallback=function(a){var c=a.status;a=a.actions;a=void 0===a?[]:a;c&&"OK"===c&&ra(a,function(a){var b=a.url;"pixel"===a.action&&Ka(b)})};var Lb=function(a,c){var b,d;null==c&&(c=l.callback_name);m.skimlinks_requests_in_flight=(null!=(b=m.skimlinks_requests_in_flight)?b:0)+1;if(null==a||!a.length)return m[c](),
!1;b=t('{"pubcode":"'+x+'","domains":_DOMAIN_LIST_,"page":"'+m.location.href+'"}');var e="//r.skimresources.com/api/?callback="+c+(v?"&dnt=1":"")+(y?"&fdnt=1":"")+"&data="+b;b="msie"===h.detect.browser?2E3:8E3;var f=[];var g=0;for(d=a.length;g<d;g++){var k=a[g];f.push(k);e.replace("_DOMAIN_LIST_",t(w(f))).length>b&&(f=f.slice(0,-1))}e=e.replace("_DOMAIN_LIST_",t(w(f)));return U(e,!1,{})};var S=function(){return p.addEventListener?function(a,c,b){var d=3<arguments.length&&void 0!==arguments[3]?arguments[3]:
!1;if(a&&(a.nodeName||a===m))return a.addEventListener(c,b,d)}:function(a,c,b){if(a&&(a.nodeName||a===m))return a.attachEvent("on"+c,function(){return 7>h.detect.version&&!m.event?(setTimeout(function(){return b.call(a,m.event)},100),!0):b.call(a,m.event)})}}();var Jb=function(a){var c;if(Ab){var b=F(a.hostname);if(b in ua)return b="[&?]"+ua[b].name+"=(http[^&]+)",b=new RegExp(b),decodeURIComponent(null!=(c=a.href)?c.match(b).pop():void 0)||a.href}return a.href};var Kb=function(a,c){var b=h.referrer?
"&pref="+t(h.referrer):"";var d=!1;if(0<c.indexOf("#slm-")){var e=c.split("#slm-");2!==e.length||isNaN(e[1])||10*parseInt(e[1])!==10*e[1]||(c=e[0],d=e[1])}var f=r(a,"data-skimlinks-tracking")||Y;var g=r(a,"data-skimlinks-editor")&&1===parseInt(r(a,"data-skimlinks-editor"))?1:0;if(C(a,"skimwords-link")){var k=r(a,"data-skimwords-word");e=r(a,"data-skim-creative");var p=r(a,"data-skim-product");var q=l.waypointDomain;c=q+"/?id="+x+(f?"&xcust="+f:"")+(!1!==d?"&xs=9":"&xs=2")+"&url="+t(c)+"&xguid="+h.cookie+
"&xuuid="+h.uuid+"&xsessid="+h.sessid+"&isjs=1&xword="+(k?k:"")+"&xcreo="+(e?e:"")+"&xpid="+(p?p:"")+"&xed="+g+"&sref="+t(m.location)+b+(v?"&dnt=1":"")+(y?"&fdnt=1":"")+(!1!==d?"&slmcid="+d:"")+(!1!==h.timezone?"&xtz="+h.timezone:"")}else C(a,"skimlinks-inline")?(e=r(a,"data-skim-creative"),c=l.waypointDomain+"/?id="+x+(A?"&site="+A:"")+(R?"&test="+R:"")+(f?"&xcust="+f:"")+(!1!==d?"&xs=9":"&xs=8")+"&isjs=1&url="+t(c)+"&xguid="+h.cookie+"&xuuid="+h.uuid+"&xsessid="+h.sessid+"&xcreo="+(a&&null!=e?e:
0)+"&xed="+g+"&sref="+t(m.location)+"&pref="+t(h.referrer)+(v?"&dnt=1":"")+(y?"&fdnt=1":"")+(!1!==d?"&slmcid="+d:"")+(!1!==h.timezone?"&xtz="+h.timezone:"")):Pa(a,"noskimlinks")||(e=r(a,"data-skim-creative"),c=l.waypointDomain+"/?id="+x+(A?"&site="+A:"")+(R?"&test="+R:"")+(f?"&xcust="+f:"")+(!1!==d?"&xs=9":"&xs=1")+"&isjs=1&url="+t(c)+"&xguid="+h.cookie+"&xuuid="+h.uuid+"&xsessid="+h.sessid+"&xcreo="+(a&&null!=e?e:0)+"&xed="+g+"&sref="+t(m.location)+b+(v?"&dnt=1":"")+(y?"&fdnt=1":"")+(!1!==d?"&slmcid="+
d:"")+(!1!==h.timezone?"&xtz="+h.timezone:""));0<xa.length&&(c+="&"+xa);h.isAdblockUser&&!Pa(a,"noskimlinks")&&(c+="&abp=1");return c};var Lc={}.hasOwnProperty;var Mc=function(a,c){var b;var d=[];G&&(a.xrf=1);for(b in a)if(Lc.call(a,b)){var e=a[b];"data"!==b&&d.push(b+"="+e)}a.data&&d.push("data="+a.data);return c+"?"+d.join("&")};var Nc=function(a){var c=p.getElementsByTagName("body")[0];var b=p.createElement("img");b.src=a;b.width=1;b.height=1;"undefined"!==typeof b.style&&(b.style.display="none");
c.appendChild(b);return b};var Da=function(a,c){Oc(a);B&&r(a,"target",B);var b=r(a,"onclick");var d="click"===c.type||"contextmenu"===c.type;if(null!=b&&-1!==b.toString().indexOf("return false")){if(d)return d=ba(c),Ga(c),(B?m.open(d.href):m.open(d.href,B)).focus()}else return Ga(c)};var Ib=function(a){var c=ba(a);var b=c.href;var d=V(b);M(d)&&(b=Pc(c,b));""===h.cookie&&yb?Da(c,a):(a=b,d=V(a),M(d)||(d="",b=r(c,"data-skimlinks-tracking")||Y,0<a.indexOf("#slm-")&&(c=a.split("#slm-"),2!==c.length||isNaN(c[1])||
10*parseInt(c[1])!==10*c[1]||(a=c[0],d=c[1])),c={call:"track",data:t('{"pubcode":"'+x+'", "referrer":"'+m.location+'", "pref":"'+h.referrer+'", "site":"'+A+'", "url":"'+a+'", "custom":"'+(b||"")+'", "xtz":'+h.timezone+', "uuid":"'+h.uuid+'", "slmcid":"'+d+'", "product":"1"}')},v&&(c.dnt=v),y&&(c.fdnt=1),c=Mc(c,"//t.skimresources.com/api/"),c=c+"&rnd="+Math.random(),Nc(c)));return!0};var Db=function(a,c,b){if(0===c)return b;try{return a()}catch(d){return Db(a,c-1,b)}};var Fb=function(a){if(null==a)return null;
for(;"A"!==a.nodeName.toUpperCase();)if(a=Db(function(){return a.parentNode},3,null),null==a)return null;return a};var Hb=function(a){return a in ua};var Pc=function(a,c){var b=Qc(c);b!==c&&(Ia(a),Ja(a,b));return b};var Qc=function(a){return a=h.cookie?a.replace(/([&\?]{1})xguid=([a-fA-F0-9]{32})/,"$1xguid="+h.cookie):a.replace(/([&\?]{1}xguid=[a-fA-F0-9]{32})/,"")};var Oc=function(a){var c,b;var d=g("skimlinks_strip_attribute",!1);if(!d)return!1;for(b in d)if(D(d,b)){var e=d[b];(c=r(a,b))&&0===c.indexOf(e)&&
(c=c.substr(e.length),r(a,b,c))}return!0};var E=function(){if(l.has_been_called)return!1;l.has_been_called=!0;return La(Ma(),"skimlinksBeaconSecondaryCallback")};var Rc=function(){if(h.skimlinksEnabled){var a=Ma();La(a);a:if(a=p){var c=fc(Eb,200);try{xb&&S(a,"mouseup",c,!0),S(a,"click",c,!0),S(a,"auxclick",c,!0),S(a,"contextmenu",c,!0),S(a,"touchstart",c,!0)}catch(b){a=!1;break a}a=!0}else a=!1;return a}};K.on("skim_js_start",function(){m.skimlinks_revenue_forecast=window.skimlinks_revenue_forecast=
!1;l.tracking&&!/^[a-z0-9_\\|]+$/i.test(l.tracking)&&(l.tracking=!1);if(G&&g("skimlinks"))return!1;Rc();var a=function(){if(l.has_been_called)return!0;try{p.documentElement.doScroll("left")}catch(d){return setTimeout(a,50),!1}return E()};var c=function(){return function(){return p.addEventListener?function(){p.removeEventListener("DOMContentLoaded",c,!1);E();return!0}:p.attachEvent?function(){p.detachEvent("onreadystatechange",c);E();return!0}:function(){E();return!0}}}(this)();if("complete"===p.readyState)return setTimeout(E,
1);if(p.addEventListener)return p.addEventListener("DOMContentLoaded",c,!1),m.addEventListener("load",E,!1);if(p.attachEvent){p.attachEvent("onreadystatechange",c);m.attachEvent("onload",E);var b=!1;try{b=null===m.frameElement}catch(d){}if(p.documentElement.doScroll&&b)return a()}});null==m.skimlinksBeaconCallback&&(m.skimlinksBeaconCallback=Ob);null==m.skimlinksBeaconSecondaryCallback&&(m.skimlinksBeaconSecondaryCallback=Nb);null==m.skimlinksBeaconAuxCallback&&(m.skimlinksBeaconAuxCallback=Mb);var sa=
!1,J=!1,P=null,Q=null,Sc={detect:function(a){a:{try{var c=navigator.userAgent.toLowerCase();if(-1===c.indexOf("firefox")&&-1===c.indexOf("chrome")){J=!0;sa=!1;break a}}catch(b){}c=""+11*Math.random();P=new Image;P.onload=lb;P.src="//p.skimresources.com/px.gif?ch=*&rn=*".replace(/\*/,"1").replace(/\*/,c);Q=new Image;Q.onload=lb;Q.src="//p.skimresources.com/px.gif?ch=*&rn=*".replace(/\*/,"2").replace(/\*/,c)}kb(a,250)}};(function(){if(!m.__SKIM_JS_GLOBAL__){m.__SKIM_JS_GLOBAL__={getDebugInfo:mc};if(jc(l.hostname)||
ya&&gc(ya))h.skimlinksEnabled=!1,h.skimwordsEnabled=!1,h.unlinkedEnabled=!1;"msie"===h.detect.browser&&8>=h.detect.version&&(h.skimwordsEnabled=!1);Sc.detect(function(a){h.isAdblockUser=a});K.publish("skim_js_init");K.publish("skim_js_start")}})()})();
