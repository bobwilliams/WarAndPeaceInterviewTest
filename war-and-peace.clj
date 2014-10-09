
(def pronouns 
  [ "all" "another" "any" "anybody" "anyone" "anything"
    "both"
    "each" "either" "everybody" "everyone" "everything"
    "few"
    "he" "her" "hers" "herself" "him" "himself" "his"
    "I" "it" "its" "itself"
    "many" "me" "mine" "more" "most" "much" "my" "myself"
    "neither" "no one" "nobody" "none" "nothing"
    "one" "other" "others" "our" "ours" "ourselves"
    "several" "she" "some" "somebody" "someone" "something"
    "that" "their" "theirs" "them" "themselves" "these" "they" "this" "those"
    "us"
    "we" "what" "whatever" "which" "whichever" "who" "whoever" "whom" "whomever" "whose"
    "you" "your" "yours" "yourself" "yourselves"])

(defn count-substring [txt sub]
  (count (re-seq (re-pattern sub) txt)))

(defn elapsed-time-msg [start]
  (println (str "Execution Time: " (- (System/currentTimeMillis) start)) "ms (100 Executions)"))

(let [start-time (System/currentTimeMillis)
      book-text  (slurp "./WarAndPeace.txt")
      pronoun-counts (->> pronouns
                          (map #(count-substring book-text %)))]
  (println "War And Peace Interview Test...\nCounts for all pronouns in ascending order")
  (println (sort-by last (zipmap pronouns pronoun-counts)))
  (elapsed-time-msg start-time))
