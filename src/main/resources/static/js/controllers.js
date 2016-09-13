app.factory('SortAPI', function ($resource) {
        return $resource("/sort");
    });

app.controller("SortController", function($scope, SortAPI, $timeout) {
        SortAPI.query(function(data) {
            $scope.sortResults = data;
        });

        $scope.insertNumbers = function () {
            SortAPI.save($scope.numbers).$promise.then(function(data) {
                $scope.sortResults.push(data); // Make sure we update the result table
            }, function(error) {
                switch (error.data.status) {
                    case 412:
                        $scope.errorMsg = 'Invalid input: Use format: 1,2,3,4,5,6';
                        break;
                    case 417:
                        $scope.errorMsg = 'Something went wrong while storing data';
                        break;
                    default:
                        $scope.errorMsg = 'An unknown error occurred'
                }
                $timeout(function() {$scope.errorMsg = ''}, 3000); // Hide error message after 3 seconds.
            });
            $scope.numbers = "";
        }
    });