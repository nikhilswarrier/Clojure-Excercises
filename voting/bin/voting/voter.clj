(ns voting.voter)

(def voters #{})
(def candidates {"10" 0 "11" 0 "12" 0 "13" 0 "14" 0})

(defn display-results [candidate]
  (println "The winner is " (key (apply max-key val candidate)))
  ) 

(defn vote [candName]
  (def candidates (assoc candidates candName(inc (get candidates candName))))
   )
 
 (defn set-candidate []
  (println "Enter candidate to vote")
  (let [candName (read-line)]
                     (if(not (contains? candidates candName ))
                       (do
                         (println "Incorrect Candidate") 
                         (set-candidate)
                        )(vote candName)
                       )
                     )
  )
 
(defn take-voter []
  (println "Enter voter Id")
  (let [voteName (read-line)]  
  (if(= voteName (some #{voteName} voters))
    (do
      (println "You cast your vote") 
      (take-voter)
     )
    (set-candidate)
    )
  (def voters (conj voters voteName))
  )
  )

(defn display-voter []
(println voters)
)

(defn start []
  (println "start voting")
  (votingSystem)
  )

(defn votingSystem []
  (while true
  (println "Enter your choice")
  (println "1.Start")
  (println "2.cast vote")
  (println "3.show results")
  (println "4.Exit")
 (let [mystr (read-line)]
  (case mystr
    "1" (start)    
    "2" (take-voter)
    "3" (display-results candidates) 
    "4" (System/exit 0)
    "5" (display-voter)
    "default"
    )))
  )
       
 