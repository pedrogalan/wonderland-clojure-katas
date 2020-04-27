(ns alphabet-cipher.coder)

(defn letter-from-matrix [x y]
  (let [char-to-int #(- (int %) (int \a))
        n           (char-to-int x)
        m           (char-to-int y)]
    (char (+ (int \a) (rem (+ n m) 26)))))

(defn encode [keyword message]
  (let [k (apply str (repeat 10 keyword))]
    (apply str (map letter-from-matrix k message))))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
