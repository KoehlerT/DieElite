(function(){var h=this,aa=function(a,b){var d=Array.prototype.slice.call(arguments,1);return function(){var b=d.slice();b.push.apply(b,arguments);return a.apply(this,b)}};var m=function(a){a=parseFloat(a);return isNaN(a)||1<a||0>a?0:a};var ba=m("0.20"),ca=m("0.0"),da=m("0.02"),ea=m("0.0");var fa=Array.prototype.forEach?function(a,b){Array.prototype.forEach.call(a,b,void 0)}:function(a,b){for(var d=a.length,c="string"==typeof a?a.split(""):a,e=0;e<d;e++)e in c&&b.call(void 0,c[e],e,a)};var ha=function(a,b){return null!==a&&b in a};var n=String.prototype.trim?function(a){return a.trim()}:function(a){return/^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]},q=function(a){return-1!=p.indexOf(a)},r=function(a,b){return a<b?-1:a>b?1:0};var p;a:{var t=h.navigator;if(t){var u=t.userAgent;if(u){p=u;break a}}p=""}var ia=function(a){for(var b=/(\w[\w ]+)\/([^\s]+)\s*(?:\((.*?)\))?/g,d=[],c;c=b.exec(a);)d.push([c[1],c[2],c[3]||void 0]);return d};var ka=function(){function a(a){a:{var b=c;for(var e=a.length,k="string"==typeof a?a.split(""):a,l=0;l<e;l++)if(l in k&&b.call(void 0,k[l],l,a)){b=l;break a}b=-1}return d[0>b?null:"string"==typeof a?a.charAt(b):a[b]]||""}var b=p;if(q("Trident")||q("MSIE"))return ja(b);b=ia(b);var d={};fa(b,function(a){d[a[0]]=a[1]});var c=aa(ha,d);return q("Opera")?a(["Version","Opera"]):q("Edge")?a(["Edge"]):!q("Chrome")&&!q("CriOS")||q("Edge")?(b=b[2])&&b[1]||"":a(["Chrome","CriOS"])},ja=function(a){var b=/rv: *([\d\.]*)/.exec(a);
if(b&&b[1])return b[1];b="";var d=/MSIE +([\d\.]+)/.exec(a);if(d&&d[1])if(a=/Trident\/(\d.\d)/.exec(a),"7.0"==d[1])if(a&&a[1])switch(a[1]){case "4.0":b="8.0";break;case "5.0":b="9.0";break;case "6.0":b="10.0";break;case "7.0":b="11.0"}else b="7.0";else b=d[1];return b};var v=function(a){var b=!1,d;return function(){b||(d=a(),b=!0);return d}};var w=function(a){w[" "](a);return a};w[" "]=function(){};var la=function(){if(!h.crypto)return Math.random();try{var a=new Uint32Array(1);h.crypto.getRandomValues(a);return a[0]/65536/65536}catch(b){return Math.random()}},x=function(a,b){if(a)for(var d in a)Object.prototype.hasOwnProperty.call(a,d)&&b.call(void 0,a[d],d,a)},ma=v(function(){return q("Google Web Preview")||1E-4>Math.random()}),na=v(function(){var a;if(a=q("Trident")||q("MSIE")){var b=ka();a=0;b=n(String(b)).split(".");for(var d=n("11").split("."),c=Math.max(b.length,d.length),e=0;0==a&&e<
c;e++){var f=b[e]||"",g=d[e]||"";do{f=/(\d*)(\D*)(.*)/.exec(f)||["","","",""];g=/(\d*)(\D*)(.*)/.exec(g)||["","","",""];if(0==f[0].length&&0==g[0].length)break;a=r(0==f[1].length?0:parseInt(f[1],10),0==g[1].length?0:parseInt(g[1],10))||r(0==f[2].length,0==g[2].length)||r(f[2],g[2]);f=f[3];g=g[3]}while(0==a)}a=!(0<=a)}return a});var oa=/^true$/.test("false"),pa=/^true$/.test("true");var y=null,ra=function(){var a=qa,b=[],d=0,c;for(c in a)b[d++]=a[c];this.c={};this.a={};a=b||[];b=0;for(d=a.length;b<d;++b)this.a[a[b]]=""},z=function(){if(null===y){y="";try{var a="";try{a=h.top.location.hash}catch(d){a=h.location.hash}if(a){var b=a.match(/\bdeid=([\d,]+)/);y=b?b[1]:""}}catch(d){}}return y},B=function(a,b,d){var c=A;if(d?c.a.hasOwnProperty(d)&&""==c.a[d]:1){var e;e=(e=z())?(e=e.match(new RegExp("\\b("+a.join("|")+")\\b")))?e[0]:null:null;if(e)a=e;else a:{if(!na()&&!ma()&&(e=Math.random(),
e<b)){e=la();a=a[Math.floor(e*a.length)];break a}a=null}a&&""!=a&&(d?c.a.hasOwnProperty(d)&&(c.a[d]=a):c.c[a]=!0)}},sa=function(){var a=A,b=[];x(a.c,function(a,c){b.push(c)});x(a.a,function(a){""!=a&&b.push(a)});return b};var qa={g:2,h:10,i:12,j:13},A=null;var ta=/^UA-\d+-\d+%3A[\w-]+(?:%2C[\w-]+)*(?:%3BUA-\d+-\d+%3A[\w-]+(?:%2C[\w-]+)*)*$/,ua=/^[\w-]+(?:\.[\w-]+)*$/,C=/^\d+\.fls\.doubleclick\.net$/,va=/;gac=([^;?]+)/,wa=/;gclaw=([^;?]+)/,D=function(a,b){if(C.test(a.location.host)){if((b=a.location.href.match(wa))&&2==b.length&&b[1].match(ua))return b[1]}else{var d=(b||"_gcl")+"_aw";b=[];a=a.cookie.split(";");d=new RegExp("^\\s*"+d+"=\\s*(.*?)\\s*$");for(var c=0;c<a.length;c++){var e=a[c].match(d);e&&b.push(e[1])}a=[];if(b&&0!=b.length)for(d=0;d<b.length;d++)c=
b[d].split("."),3==c.length&&"GCL"==c[0]&&c[1]&&a.push(c[2]);if(0<a.length)return a.join(".")}return""};var xa=function(a,b,d){a=E(a,!0);if(a[b])return!1;a[b]=[];a[b][0]=d;return!0},E=function(a,b){var d=a.GooglebQhCsO;d||(d={},b&&(a.GooglebQhCsO=d));return d};var F=null,G=null,ya=function(a){for(var b=[],d=0,c=0;c<a.length;c++){var e=a.charCodeAt(c);255<e&&(b[d++]=e&255,e>>=8);b[d++]=e}if(!F)for(F={},G={},a=0;65>a;a++)F[a]="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(a),G[a]="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".charAt(a);a=G;d=[];for(c=0;c<b.length;c+=3){var f=b[c],g=(e=c+1<b.length)?b[c+1]:0,k=c+2<b.length,l=k?b[c+2]:0,Ha=f>>2;f=(f&3)<<4|g>>4;g=(g&15)<<2|l>>6;l&=63;k||(l=64,e||(g=64));d.push(a[Ha],
a[f],a[g],a[l])}return d.join("")};var H=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^/?#]*)@)?([^/#?]*?)(?::([0-9]+))?(?=[/#?]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/,za=function(a){var b=a.match(H);a=b[5];var d=b[6];b=b[7];var c="";a&&(c+=a);d&&(c+="?"+d);b&&(c+="#"+b);return c},I=function(a,b,d,c){for(var e=d.length;0<=(b=a.indexOf(d,b))&&b<c;){var f=a.charCodeAt(b-1);if(38==f||63==f)if(f=a.charCodeAt(b+e),!f||61==f||38==f||35==f)return b;b+=e+1}return-1},J=/#|$/,K=function(a,b){var d=a.search(J),c=I(a,0,b,d);if(0>c)return null;var e=a.indexOf("&",
c);if(0>e||e>d)e=d;c+=b.length+1;return decodeURIComponent(a.substr(c,e-c).replace(/\+/g," "))},Aa=/[?&]($|#)/,L=function(a,b,d){for(var c=a.search(J),e=0,f,g=[];0<=(f=I(a,e,b,c));)g.push(a.substring(e,f)),e=Math.min(a.indexOf("&",f)+1||c,c);g.push(a.substr(e));a=g.join("").replace(Aa,"$1");d=null!=d?"="+encodeURIComponent(String(d)):"";(b+=d)?(d=a.indexOf("#"),0>d&&(d=a.length),c=a.indexOf("?"),0>c||c>d?(c=d,e=""):e=a.substring(c+1,d),d=[a.substr(0,c),e,a.substr(d)],a=d[1],d[1]=b?a?a+"&"+b:b:a,b=
d[0]+(d[1]?"?"+d[1]:"")+d[2]):b=a;return b};var M=function(a,b,d,c){var e=K(d,"fmt");if(c){var f=K(d,"random"),g=K(d,"label")||"";if(!f)return!1;f=ya(decodeURIComponent(g.replace(/\+/g," "))+":"+decodeURIComponent(f.replace(/\+/g," "))).replace(/[.]*$/,"");if(!xa(a,f,c))return!1}e&&4!=e&&(d=L(d,"rfmt",e));d=L(d,"fmt",4);e=b.createElement("script");e.src=d;e.onload=function(){a.google_noFurtherRedirects&&c&&c.call&&(a.google_noFurtherRedirects=null,c())};b.getElementsByTagName("script")[0].parentElement.appendChild(e);return!0};var N="google_conversion_id google_conversion_format google_conversion_type google_conversion_order_id google_conversion_language google_conversion_value google_conversion_evaluemrc google_conversion_currency google_conversion_domain google_conversion_label google_conversion_color google_disable_viewthrough google_enable_display_cookie_match google_remarketing_only google_remarketing_for_search google_conversion_items google_conversion_merchant_id google_user_id google_custom_params google_conversion_date google_conversion_time google_conversion_js_version onload_callback opt_image_generator google_conversion_page_url google_conversion_referrer_url google_gtm google_gcl_cookie_prefix google_read_gcl_cookie_opt_out google_basket_feed_country google_basket_feed_language google_basket_discount google_basket_transaction_type google_disable_merchant_reported_conversions".split(" "),
O=["google_conversion_first_time","google_conversion_snippets"],P=function(a){return null!=a?encodeURIComponent(String(a)):""},Q=function(a){if(null!=a){a=String(a).substring(0,512);var b=a.indexOf("#");return-1==b?a:a.substring(0,b)}return""},R=function(a,b){b=P(b);return""!=b&&(a=P(a),""!=a)?"&".concat(a,"=",b):""},S=function(a){var b=typeof a;return null==a||"object"==b||"function"==b?null:String(a).replace(/,/g,"\\,").replace(/;/g,"\\;").replace(/=/g,"\\=")},Ba=function(a){if((a=a.google_custom_params)&&
"object"==typeof a&&"function"!=typeof a.join){var b=[];for(g in a)if(Object.prototype.hasOwnProperty.call(a,g)){var d=a[g];if(d&&"function"==typeof d.join){for(var c=[],e=0;e<d.length;++e){var f=S(d[e]);null!=f&&c.push(f)}d=0==c.length?null:c.join(",")}else d=S(d);(c=S(g))&&null!=d&&b.push(c+"="+d)}var g=b.join(";")}else g="";return""==g?"":"&".concat("data=",encodeURIComponent(g))},Ca=function(a){if(null!=a){a=a.toString();if(2==a.length)return R("hl",a);if(5==a.length)return R("hl",a.substring(0,
2))+R("gl",a.substring(3,5))}return""};function T(a){return"number"!=typeof a&&"string"!=typeof a?"":P(a.toString())}
var Da=function(a){if(!a)return"";a=a.google_conversion_items;if(!a)return"";for(var b=[],d=0,c=a.length;d<c;d++){var e=a[d],f=[];e&&(f.push(T(e.value)),f.push(T(e.quantity)),f.push(T(e.item_id)),f.push(T(e.adwords_grouping)),f.push(T(e.sku)),b.push("("+f.join("*")+")"))}return 0<b.length?"&item="+b.join(""):""},Ea=function(a,b){if(b.google_read_gcl_cookie_opt_out||b.google_remarketing_only||b.google_conversion_domain)return"";var d="";if(b.google_gcl_cookie_prefix&&/^[a-zA-Z0-9_]+$/.test(b.google_gcl_cookie_prefix))return d=
D(a,b.google_gcl_cookie_prefix),R("gclaw",d);(b=D(a))&&(d=R("gclaw",b));if(C.test(a.location.host))var c=(c=a.location.href.match(va))&&2==c.length&&c[1].match(ta)?decodeURIComponent(c[1]):"";else{b=[];a=a.cookie.split(";");for(var e=/^\s*_gac_(UA-\d+-\d+)=\s*(.+?)\s*$/,f=0;f<a.length;f++){var g=a[f].match(e);g&&b.push({b:g[1],value:g[2]})}a={};if(b&&b.length)for(e=0;e<b.length;e++)f=b[e].value.split("."),"1"==f[0]&&3==f.length&&f[1]&&(a[b[e].b]||(a[b[e].b]=[]),a[b[e].b].push({timestamp:f[1],f:f[2]}));
b=[];for(c in a){e=[];f=a[c];for(g=0;g<f.length;g++)e.push(f[g].f);b.push(c+":"+e.join(","))}c=0<b.length?b.join(";"):""}return d+(c?R("gac",c):"")},Fa=function(a,b,d){var c=[];if(a){var e=a.screen;e&&(c.push(R("u_h",e.height)),c.push(R("u_w",e.width)),c.push(R("u_ah",e.availHeight)),c.push(R("u_aw",e.availWidth)),c.push(R("u_cd",e.colorDepth)));a.history&&c.push(R("u_his",a.history.length))}d&&"function"==typeof d.getTimezoneOffset&&c.push(R("u_tz",-d.getTimezoneOffset()));b&&("function"==typeof b.javaEnabled&&
c.push(R("u_java",b.javaEnabled())),b.plugins&&c.push(R("u_nplug",b.plugins.length)),b.mimeTypes&&c.push(R("u_nmime",b.mimeTypes.length)));return c.join("")};function Ga(a){a=a?a.title:"";if(void 0==a||""==a)return"";var b=function(a){try{return decodeURIComponent(a),!0}catch(e){return!1}};a=encodeURIComponent(a);for(var d=256;!b(a.substr(0,d));)d--;return"&tiba="+a.substr(0,d)}
var U=function(a,b,d,c){var e="";if(b){if(a.top==a)var f=0;else{var g=a.location.ancestorOrigins;if(g)f=g[g.length-1]==a.location.origin?1:2;else{g=a.top;try{var k;if(k=!!g&&null!=g.location.href)c:{try{w(g.foo);k=!0;break c}catch(l){}k=!1}f=k}catch(l){f=!1}f=f?1:2}}a=d?d:1==f?a.top.location.href:a.location.href;e+=R("frm",f);e+=R("url",Q(a));e+=R("ref",Q(c||b.referrer))}return e},V=function(a,b){return!(oa||b&&Ia.test(navigator.userAgent))||a&&a.location&&a.location.protocol&&"https:"==a.location.protocol.toString().toLowerCase()?
"https:":"http:"},Ja=function(a,b,d){d=d.google_remarketing_only?"googleads.g.doubleclick.net":d.google_conversion_domain||"www.googleadservices.com";return V(a,/www[.]googleadservices[.]com/i.test(d))+"//"+d+b},La=function(a,b,d,c){var e="/?";"landing"==c.google_conversion_type&&(e="/extclk?");e=[c.google_remarketing_only?"/pagead/viewthroughconversion/":"/pagead/conversion/",P(c.google_conversion_id),e,"random=",P(c.google_conversion_time)].join("");e=Ja(a,e,c);a=[R("cv",c.google_conversion_js_version),
R("fst",c.google_conversion_first_time),R("num",c.google_conversion_snippets),R("fmt",c.google_conversion_format),R("userId",c.google_user_id),R("value",c.google_conversion_value),R("evaluemrc",c.google_conversion_evaluemrc),R("currency_code",c.google_conversion_currency),R("label",c.google_conversion_label),R("oid",c.google_conversion_order_id),R("bg",c.google_conversion_color),Ca(c.google_conversion_language),R("guid","ON"),!c.google_conversion_domain&&"GooglemKTybQhCsO"in h&&"function"==typeof h.GooglemKTybQhCsO?
R("resp","GooglemKTybQhCsO"):"",R("disvt",c.google_disable_viewthrough),R("eid",sa().join()),Fa(a,b,c.google_conversion_date),Ba(c),R("gtm",c.google_gtm),Ea(d,c),U(a,d,c.google_conversion_page_url,c.google_conversion_referrer_url),c.google_remarketing_for_search&&!c.google_conversion_domain?"&srr=n":"",Ga(d)].join("");b=z();a+=0<b.length?"&debug_experiment_id="+b:"";c.google_remarketing_only||c.google_conversion_domain?c=a:(Ka(c)&&!c.google_basket_transaction_type&&(c.google_basket_transaction_type=
"mrc"),b=[R("mid",c.google_conversion_merchant_id),R("fcntr",c.google_basket_feed_country),R("flng",c.google_basket_feed_language),R("dscnt",c.google_basket_discount),R("bttype",c.google_basket_transaction_type)].join(""),c=[a,b,Da(c)].join(""),c=2E3<c.length?[a,R("item","elngth")].join(""):c);return e+c},Ma=function(a,b,d,c,e,f,g){return'<iframe name="'+a+'"'+(g?' id="'+g+'"':"")+' title="'+b+'" width="'+c+'" height="'+e+'"'+(d?' src="'+d+'"':"")+' frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true"'+
(f?' style="display:none"':"")+' scrolling="no"></iframe>'},Na=function(a){return{ar:1,bg:1,cs:1,da:1,de:1,el:1,en_AU:1,en_US:1,en_GB:1,es:1,et:1,fi:1,fr:1,hi:1,hr:1,hu:1,id:1,is:1,it:1,iw:1,ja:1,ko:1,lt:1,nl:1,no:1,pl:1,pt_BR:1,pt_PT:1,ro:1,ru:1,sk:1,sl:1,sr:1,sv:1,th:1,tl:1,tr:1,vi:1,zh_CN:1,zh_TW:1}[a]?a+".html":"en_US.html"},Ia=/Android ([01]\.|2\.[01])/i,Oa=function(a,b){(b=!b.google_remarketing_only||!b.google_enable_display_cookie_match)||(b=!A)||(b=A,b="376635471"!=(b.a.hasOwnProperty(2)?
b.a[2]:""));if(b)return"";a=V(a,!1)+"//bid.g.doubleclick.net/xbbe/pixel?d=KAE";return Ma("google_cookie_match_frame","Google cookie match frame",a,1,1,!0,null)},Qa=function(a,b,d,c){var e="";c.google_remarketing_only&&c.google_enable_display_cookie_match&&(A&&B(["376635470","376635471"],ba,2),e=Oa(a,c));c.google_remarketing_only||c.google_conversion_domain||(1==c.google_conversion_format||2==c.google_conversion_format||3==c.google_conversion_format)&&A&&B(["659328990","659328991"],ea,10);c.google_remarketing_only||
c.google_conversion_domain||A&&B(["659428990","659428991"],ca,12);c.google_remarketing_only&&!c.google_conversion_domain&&A&&B(["759238990","759238991"],da,13);b=La(a,b,d,c);var f=function(a,b,c,d){return'<img height="'+c+'" width="'+b+'" border="0" alt="" src="'+a+'"'+(d?' style="display:none"':"")+" />"};if(0==c.google_conversion_format&&null==c.google_conversion_domain)return'<a href="'+(V(a,!1)+"//services.google.com/sitestats/"+Na(c.google_conversion_language)+"?cid="+P(c.google_conversion_id))+
'" target="_blank">'+f(b,135,27,!1)+"</a>"+e;if(1<c.google_conversion_snippets||3==c.google_conversion_format){var g=b;null==c.google_conversion_domain&&(g=3==c.google_conversion_format?b:L(b,"fmt",3));return Pa(a,d,c,g)?e:f(g,1,1,!0)+e}f=null;!c.google_conversion_domain&&Pa(a,d,c,b)&&(f="goog_conv_iframe",b="");return Ma("google_conversion_frame","Google conversion frame",b,2==c.google_conversion_format?200:300,2==c.google_conversion_format?26:13,!1,f)+e};function Ra(){return new Image}
function Pa(a,b,d,c){if(d.google_conversion_domain)return!1;try{return M(a,b,c,null)}catch(e){return!1}}
var Sa=function(a,b){var d=a.opt_image_generator&&a.opt_image_generator.call;b+=R("async","1");var c=Ra;d&&(c=a.opt_image_generator);a=c();a.src=b;a.onload=function(){}},Ta=function(a,b,d){var c=Math.floor(1E9*Math.random());c=[P(d.google_conversion_id),"/?random=",c].join("");c=V(a,!1)+"//www.google.com/ads/user-lists/"+c;a=[R("label",d.google_conversion_label),R("fmt","3"),U(a,b,d.google_conversion_page_url,d.google_conversion_referrer_url)].join("");Sa(d,c+a)},Ua=function(a,b){var d=document.createElement("IFRAME");
for(var c=[],e=[],f=0;f<b.google_conversion_items.length;f++){var g=b.google_conversion_items[f];g&&g.quantity&&(g.sku||g.item_id)&&(c.push(g.sku||g.item_id),e.push(g.quantity))}f="";null!=b.google_conversion_language&&(g=b.google_conversion_language.toString(),5==g.length&&(f="&mrc_language="+g.substring(0,2)+"&mrc_country="+g.substring(3,5)));a=V(a,!1)+"//www.google.com/ads/mrc";d.src=a+"?sku="+c.join(",")+"&qty="+e.join(",")+"&oid="+b.google_conversion_order_id+"&mcid="+b.google_conversion_merchant_id+
f;d.style.width="1px";d.style.height="1px";d.style.display="none";return d},Ka=function(a){return!a.google_disable_merchant_reported_conversions&&!!a.google_conversion_merchant_id&&!!a.google_conversion_order_id&&!!a.google_conversion_items},Va=function(a){if("landing"==a.google_conversion_type||!a.google_conversion_id||a.google_remarketing_only&&a.google_disable_viewthrough)return!1;a.google_conversion_date=new Date;a.google_conversion_time=a.google_conversion_date.getTime();a.google_conversion_snippets=
"number"==typeof a.google_conversion_snippets&&0<a.google_conversion_snippets?a.google_conversion_snippets+1:1;"number"!=typeof a.google_conversion_first_time&&(a.google_conversion_first_time=a.google_conversion_time);a.google_conversion_js_version="9";0!=a.google_conversion_format&&1!=a.google_conversion_format&&2!=a.google_conversion_format&&3!=a.google_conversion_format&&(a.google_conversion_format=3);!1!==a.google_enable_display_cookie_match&&(a.google_enable_display_cookie_match=!0);A=new ra;
pa&&(a.google_remarketing_for_search=!1);return!0},Wa=function(a){for(var b=0;b<N.length;b++)a[N[b]]=null},Xa=function(a){for(var b={},d=0;d<N.length;d++)b[N[d]]=a[N[d]];for(d=0;d<O.length;d++)b[O[d]]=a[O[d]];return b},Ya=function(a){var b=document.getElementsByTagName("head")[0];b||(b=document.createElement("head"),document.getElementsByTagName("html")[0].insertBefore(b,document.getElementsByTagName("body")[0]));var d=document.createElement("script");d.src=Ja(window,"/pagead/conversion_debug_overlay.js",
a);b.appendChild(d)};var Za=function(a,b,d){a.addEventListener?a.addEventListener(b,d,void 0):a.attachEvent&&a.attachEvent("on"+b,d)};var $a=function(a){return{visible:1,hidden:2,prerender:3,preview:4,unloaded:5}[a.visibilityState||a.webkitVisibilityState||a.mozVisibilityState||""]||0},ab=function(a){var b;a.visibilityState?b="visibilitychange":a.mozVisibilityState?b="mozvisibilitychange":a.webkitVisibilityState&&(b="webkitvisibilitychange");return b},bb=function(a,b){if(3==$a(b))return!1;a();return!0},cb=function(a,b){if(!bb(a,b)){var d=!1,c=ab(b),e=function(){!d&&bb(a,b)&&(d=!0,b.removeEventListener?b.removeEventListener(c,e,
void 0):b.detachEvent&&b.detachEvent("on"+c,e))};c&&Za(b,c,e)}};var db=function(a,b,d){var c=d.length+1,e=function(){--c;if(0>=c){var d=E(a,!1),e=d[b];e&&(delete d[b],(d=e[0])&&d.call&&d())}},f=function(a,b){var c=new Image;c.onload=a;c.src=b};if(2==d.length){var g=d[0],k=d[1];0<=I(g,0,"rmt_tld",g.search(J))&&0<=I(g,0,"ipr",g.search(J))&&!k.match(H)[6]&&(k+=za(g),d[1]=L(k,"rmt_tld","1"))}for(g=0;g<d.length;g++){k=d[g];var l=K(k,"fmt");switch(parseInt(l,10)){case 1:case 2:(l=a.document.getElementById("goog_conv_iframe"))&&!l.src?(l.onload=e,l.src=k):f(e,k);break;
case 4:M(a,a.document,k,e);break;default:f(e,k)}}e()},W=["GooglemKTybQhCsO"],X=h;W[0]in X||"undefined"==typeof X.execScript||X.execScript("var "+W[0]);for(var Y;W.length&&(Y=W.shift());){var Z;if(Z=!W.length)Z=void 0!==db;Z?X[Y]=db:X[Y]&&X[Y]!==Object.prototype[Y]?X=X[Y]:X=X[Y]={}}
(function(a,b,d){if(a)if(null!=/[\?&;]google_debug/.exec(document.URL))Ya(a);else{try{if(Va(a))if(3==$a(d)){var c=Xa(a),e="google_conversion_"+Math.floor(1E9*Math.random());d.write('<span id="'+e+'"></span>');cb(function(){try{var f=d.getElementById(e);f&&(f.innerHTML=Qa(a,b,d,c),c.google_remarketing_for_search&&!c.google_conversion_domain&&Ta(a,d,c))}catch(g){}},d)}else d.write(Qa(a,b,d,a)),a.google_remarketing_for_search&&!a.google_conversion_domain&&Ta(a,d,a);Ka(a)&&d.documentElement.appendChild(Ua(a,
a))}catch(f){}Wa(a)}})(window,navigator,document);}).call(this);
