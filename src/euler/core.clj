(ns euler.core)

(def sum (partial reduce +))

(defn sqr [x] (* x x))

(defn divides? [d n] (zero? (mod n d)))

(def fibs
  (lazy-cat [0 1] (map + (rest fibs) fibs)))

(defn sqrt [n] (Math/sqrt n))

(defn factors [n]
  (let [step
        (fn step [n p]
          (cond
           (> p (sqrt n)) (cons n nil)
           (divides? p n) (lazy-seq (cons p (step (quot n p) p)))
           :else (recur n (inc p))))]
    (step n 2)))

(def unique-factors (comp distinct factors))

(def factorize (comp frequencies factors))

(defn palindrome? [n]
  (let [s (str n)]
    (= (seq s) (reverse s))))

(defn pow [a b]
  (reduce * (repeat b a)))

(defn primes
  ([] (primes 2 []))
  ([i found-primes]
    (if (some #(zero? (rem i %)) (take-while #(<= (* % %) i) found-primes))
      (recur (inc i) found-primes)
      (cons i (lazy-seq (primes (inc i) (conj found-primes i)))))))

