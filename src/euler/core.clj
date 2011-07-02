(ns euler.core)

(defn divides? [d n] (zero? (mod n d)))

(def fibs
  (lazy-cat [0 1] (map + (rest fibs) fibs)))

(defn sqrt [n] (Math/sqrt n))

(defn factors [n]
  (let [next-factor
        (fn [n p]
          (cond
           (> p (sqrt n)) (cons n nil)
           (divides? p n) (lazy-seq (cons p (next-factor (quot n p) p)))
           :else (recur n (inc p))))]
    (next-factor n 2)))

(def unique-factors (comp distinct factors))