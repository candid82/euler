(ns euler.test.core
  (:use [euler.problems])
  (:use [clojure.test]))

(deftest problems
  (is (= (problem-1) 233168))
  (is (= (problem-2) 4613732))
  (is (= (problem-3) 6857))
  (is (= (problem-4) 906609))
  (is (= (problem-5) 232792560))
  (is (= (problem-6) 25164150))
  (is (= (problem-7) 104743))
  (is (= (problem-8) 40824))
  (is (= (problem-9) 31875000)))
