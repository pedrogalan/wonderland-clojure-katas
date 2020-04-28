(ns alphabet-cipher.coder)

(defn create-row [first-char]
  (let [base (map char (range 97 123))
        pos (- (int first-char) 97)]
    (apply concat (reverse (split-at pos base)))))

(defn create-matrix []
  (map create-row (map char (range 97 123))))

(def matrix (create-matrix))

(defn char-to-int [c]
  (- (int c) (int \a)))

(defn char-from-matrix [x y]
  (let [row-number (char-to-int x)
        col-number (char-to-int y)]
    (nth (nth matrix row-number) col-number)))

(defn column-header-from-matrix [x c]
  (let [row (nth matrix (char-to-int x))]
    (char (+ (int \a) (.indexOf row c)))))

(defn extend-keyword [keyword message]
  (loop [keyword keyword
         n (count message)
         result keyword]
    (if (>= (count result) n)
      result
      (recur keyword n (str result keyword)))))

(defn encode [keyword message]
  (apply str (map char-from-matrix (extend-keyword keyword message) message)))

(defn decode [keyword message]
  (apply str (map column-header-from-matrix (extend-keyword keyword message) message)))

(defn decipher [cipher message]
  "decypherme")
