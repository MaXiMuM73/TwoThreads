# Two threads work in turn
## Example:

14:05:12.489 [Thread-0] -----Writer working-----
14:05:12.493 [Thread-0] Number size: 3
14:05:12.493 [Thread-0] -----Writer end-----

14:05:14.498 [Thread-1] -----Reader working-----
14:05:14.499 [Thread-1] Numbers: [3324, 8385, 6356]
14:05:14.499 [Thread-1] Deleting number 3324
14:05:14.499 [Thread-1] Deleting number 8385
14:05:14.499 [Thread-1] Deleting number 6356
14:05:14.499 [Thread-1] -----Reader end-----

14:05:16.509 [Thread-0] -----Writer working-----
14:05:16.509 [Thread-0] Number size: 7
14:05:16.509 [Thread-0] -----Writer end-----

14:05:18.517 [Thread-1] -----Reader working-----
14:05:18.517 [Thread-1] Numbers: [4460, 2681, 3974, 834, 4665, 3889, 1109]
14:05:18.517 [Thread-1] Deleting number 4460
14:05:18.517 [Thread-1] Deleting number 2681
14:05:18.517 [Thread-1] Deleting number 3974
14:05:18.517 [Thread-1] Deleting number 834
14:05:18.517 [Thread-1] Deleting number 4665
14:05:18.517 [Thread-1] Deleting number 3889
14:05:18.517 [Thread-1] Deleting number 1109
14:05:18.517 [Thread-1] -----Reader end-----

14:05:20.529 [Thread-0] -----Writer working-----
14:05:20.529 [Thread-0] Number size: 4
14:05:20.529 [Thread-0] -----Writer end-----

14:05:22.539 [Thread-1] -----Reader working-----
14:05:22.539 [Thread-1] Numbers: [4924, 9201, 5802, 9278]
14:05:22.539 [Thread-1] Deleting number 4924
14:05:22.539 [Thread-1] Deleting number 9201
14:05:22.539 [Thread-1] Deleting number 5802
14:05:22.539 [Thread-1] Deleting number 9278
14:05:22.539 [Thread-1] -----Reader end-----