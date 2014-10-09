
(def pronouns 
  [ "all" "another" "any" "anybody" "anyone" "anything"
    "both"
    "each" "either" "everybody" "everyone" "everything"
    "few"
    "he" "her" "hers" "herself" "him" "himself" "his"
    "i" "it" "its" "itself"
    "many" "me" "mine" "more" "most" "much" "my" "myself"
    "neither" "no one" "nobody" "none" "nothing"
    "one" "other" "others" "our" "ours" "ourselves"
    "several" "she" "some" "somebody" "someone" "something"
    "that" "their" "theirs" "them" "themselves" "these" "they" "this" "those"
    "us"
    "we" "what" "whatever" "which" "whichever" "who" "whoever" "whom" "whomever" "whose"
    "you" "your" "yours" "yourself" "yourselves"])

(defn count-substring [txt sub]
  (count (re-seq (re-pattern (str "[\\s\\W]+" sub "[\\s\\W]+")) txt)))

(defn record-word-count [memo word]
  (assoc memo word (inc (memo word 0))))

(defn elapsed-time-msg [start]
  (println (str "Execution Time: " (- (System/currentTimeMillis) start)) "ms (100 Executions)"))

(let [start-time (System/currentTimeMillis)
      book-text  (clojure.string/lower-case (slurp "./WarAndPeace.txt"))
      pronoun-counts (->> pronouns
                          (map #(count-substring book-text %)))]
  (println "\nWar And Peace Interview Test...\n\nCounts for all pronouns in ascending order\n")
  (println (sort-by last (zipmap pronouns pronoun-counts)))
  (println "\nCounts for all words:\n")
  (println (->> (clojure.string/split book-text #"[\s\W]+")
                (reduce record-word-count {})
                (sort-by last)))
  (elapsed-time-msg start-time))