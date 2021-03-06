'use strict';

app.factory('$$attributes',
['$http', 'util', '$$resources',
function( $http, util, $$resources ){

  var cache;
  var strcmp = util.strcmp;

  var $$attributes = window.$$attributes = function(){
    if( cache ){ return Promise.resolve(cache); }

    return $$resources()
      .then(function( res ){
        return res.attributeGroups;
      })

      .then(function( attrs ){

        _.forEach( attrs, function( orgAttrs, orgId ){
          orgAttrs.sort(function(a, b){
            return strcmp( a.name.toLowerCase(), b.name.toLowerCase() );
          });
        } );

        return attrs;
      })

      .then(function( attrs ){
        return cache = attrs;
      })
    ;
  };

  return $$attributes;

}]);
