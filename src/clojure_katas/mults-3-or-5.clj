(ns clojure-katas.mults-3-or-5)



;; Kata Description
;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

;; Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

;; Note: If the number is a multiple of both 3 and 5, only count it once. Also, if a number is negative, return 0(for languages that do have them)

(def mults-of-three (iterate (partial + 3) 0))
(def mults-of-five (iterate (partial + 5) 0))
(defn solution [number]
    (reduce + (distinct (concat (take (/ number 3) mults-of-three) (take (/ number 5) mults-of-five)))))


(solution 10)
;; => 23
