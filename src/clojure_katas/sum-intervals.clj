(ns clojure-katas.sum-intervals
  (:require [clojure.test :as test]))

(comment
  Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.

  Intervals
  Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

  Overlapping Intervals
  List containing overlapping intervals:

  [
   [1,4],
   [7, 10],
   [3, 5]
   ]
  The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.)

(defn expand [[a z]] (range a z))

(defn sum-intervals
  [intervals]
  (->> intervals
    (mapcat expand)
    set
    count))

(sum-intervals [ [1 5] [10 15] [-1 3] ])
;; => 11

(sum-intervals [ [1 5] ])
;; => 4


(test/deftest sum-intervals-test

  (test/is (= (sum-intervals [ [1 5] [10 15] [-1 3] ]) 11))
  (test/is (= (sum-intervals [ [1 5] ]) 4)))

(test/run-tests)
;; => {:test 1, :pass 2, :fail 0, :error 0, :type :summary}
