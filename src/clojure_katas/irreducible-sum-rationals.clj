(ns clojure-katas.irreducible-sum-rationals)

;; Kata Description
;; You will have a list of rationals in the form

;; lst = [ [numer_1, denom_1] , ... , [numer_n, denom_n] ]
;; or
;; 
;; lst = [ (numer_1, denom_1) , ... , (numer_n, denom_n) ]
;; where all numbers are positive integers. You have to produce their sum N / D in an irreducible form: this means that N and D have only 1 as a common divisor.

;;  Example:
;;  [ [1, 2], [1, 3], [1, 4] ]  -->  [13, 12]
;;  1/2  +  1/3  +  1/4     =      13/12

(defn convert-to-rat [[n d]]
  (/ n d))

(defn split-rat [r]
  (if (ratio? r)
    [(numerator r) (denominator r)]
    r))

(defn sum-fracts [l]
  (if (empty? l)
   nil
    (split-rat (reduce + (map convert-to-rat l)))))

(sum-fracts [ [1, 2], [1, 3], [1, 4] ])
;; => [13 12]
