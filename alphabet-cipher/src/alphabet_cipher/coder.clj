(ns alphabet-cipher.coder)

(defn letter-from-matrix [x y]
  (let [char-to-int #(- (int %) (int \a))
        n           (char-to-int x)
        m           (char-to-int y)]
    (char (+ (int \a) (rem (+ n m) 26)))))

(defn extend-keyword [keyword message]
  (loop [keyword keyword
         n (count message)
         result keyword]
    (if (>= (count result) n)
      result
      (recur keyword n (str result keyword)))))

(defn encode [keyword message]
  (apply str (map letter-from-matrix (extend-keyword keyword message) message)))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
