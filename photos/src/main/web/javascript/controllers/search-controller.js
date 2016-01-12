angular.module('photoApp')
	.controller('SearchController', ['$scope', '$rootScope', 'PhotoService', function($scope, $rootScope, photoService) {

        $rootScope.results = {};

        $scope.search = function() {
        	var selectedFacets = {};

			if ($rootScope.results.hasOwnProperty("facets")) {
				for (var facetName in $rootScope.results.facets) {
					if ($rootScope.results.facets.hasOwnProperty(facetName)) {
						var facetsToSelect = [];

						for (var facetValue in $rootScope.results.facets[facetName]) {

							var name = $rootScope.results.facets[facetName][facetValue].name;
							var selected = $rootScope.results.facets[facetName][facetValue].selected;

							if (selected) {
								facetsToSelect.push(name);
							}
						}

						if (facetsToSelect.length !== 0) {
							selectedFacets[facetName] = facetsToSelect;
						}
					}
				}
			}

        	photoService.get(selectedFacets, successCallback, errorCallback);

        }

        $scope.update = function() {
        	photoService.update($rootScope.results.results,
				function() {
					$scope.search();
					console.log("success");
				},
				function() {
					console.log("error")
				}
        	 );
        }

        successCallback = function(response) {
            $rootScope.results = response.data;
        }

        errorCallback = function(response) {
            $rootScope.results = 'error';
        }
	}]);