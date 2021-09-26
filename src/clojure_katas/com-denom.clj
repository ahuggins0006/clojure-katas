(ns clojure-katas.com-denom
  (:require [clojure.test :as test]))

  ;; Common denominators

  ;; You will have a list of rationals in the form

  ;; { {numer_1, denom_1} , ... {numer_n, denom_n} }
  ;; or
  ;; [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
  ;; or
  ;; [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
  ;; where all numbers are positive ints. You have to produce a result in the form:

  ;; (N_1, D) ... (N_n, D)
  ;; or
  ;; [ [N_1, D] ... [N_n, D] ]
  ;; or
  ;; [ (N_1', D) , ... (N_n, D) ]
  ;; or
  ;; {{N_1, D} ... {N_n, D}}
  ;; or
  ;; "(N_1, D) ... (N_n, D)"
  ;; depending on the language (See Example tests) in which D is as small as possible and

  ;; N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.

(defn gcd [a b]
        (if (zero? b)
          a
          (recur b (mod a b))))

(defn lcm
      [a b]
      (/ (* a b) (gcd a b)))

(defn lcmv [& v] (reduce lcm v))

(defn find-r [a] (->> (map second a) (apply lcmv)))

(defn convert-ratio [r [n d]] [(* n (/ r d)) r])

(defn convert-fracts [lst]
  (let [r (find-r lst)]
    (map (partial convert-ratio r) lst)
    )
)

(test/deftest a-test1
(test/testing "Test 1"
  (def a  [[1, 2], [1, 3], [1, 4]] )
  (def b  [[6, 12], [4, 12], [3, 12]] )
  (test/is (= (convert-fracts a) b))))

(test/run-tests)
;; => {:test 1, :pass 1, :fail 0, :error 0, :type :summary}
