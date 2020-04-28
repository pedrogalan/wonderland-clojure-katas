(ns wonderland-number.finder)

(defn- same-digits? [n m]
  (let [n-digits (-> n str set)
        m-digits (-> m str set)]
    (= n-digits m-digits)))

(defn- wonderland-number? [n]
  (and (same-digits? n (* 2 n))
       (same-digits? n (* 3 n))
       (same-digits? n (* 4 n))
       (same-digits? n (* 5 n))
       (same-digits? n (* 6 n))))

(defn wonderland-number []
  (first (filter wonderland-number? (range 100000 999999))))
