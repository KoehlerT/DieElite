(function(){
  if(window.dxRuntime) {
    return;
  }

  window.dxRuntime = {
    start: function() {
      window.addEventListener('message', this.receiveMessage, false);
    },

    receiveMessage: function(event) {
      try {
        var message = JSON.parse(event.data);
        if(message.type === 'clickUrl') {
          dxRuntime.registerClickThrough(message.clickUrl);
        }
      } catch (e) {
        return;
      }
    },

    registerClickThrough: function(clickUrl) {
      var clickId = dxRuntime.getClickId();

      if(clickId) {
        document.addEventListener('click', function(e) {
          if(dxRuntime.shouldClickThrough(e, clickId)) {
            window.open(clickUrl);
          }
        });
      }
    },

    shouldClickThrough: function(clickEvent, clickId) {
      if(clickEvent.button === 0) {
        var path = clickEvent.path || dxRuntime.getPath(clickEvent.target, []);
        for(var i = 0; i < path.length; i++) {
          if(path[i].id === clickId) {
            return true;
          }
        }
      }
      return false;
    },

    getClickId: function() {
      var clickMetaTag = dxRuntime.getMetaTagByName('click.through');
      return clickMetaTag && clickMetaTag.content;
    },

    getMetaTagByName: function(name) {
      var metaTags = document.getElementsByTagName("meta");
      for(var i = 0; i < metaTags.length; i++) {
        if(metaTags[i].name === name) {
          return metaTags[i];
        }
      }
      return null;
    },

    getPath: function(el, path) {
      path.push(el);
      if(el.nodeName.toLowerCase() !== 'body') {
        path = dxRuntime.getPath(el.parentElement, path);
      }
      return path;
    }
  };
  dxRuntime.start();
})();
