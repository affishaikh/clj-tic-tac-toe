(ns tic-tac-toe.core)

(defn print-board [board]
  (println
    (apply str
           (conj
             (map
               (partial apply #(str "|" %1 "|" %2 "|" %3 "|\n" "_______\n"))
               (partition 3 board))
             "_______\n"))))

(defn has-won [played-moves]
  (some (fn [winning-condition] (every? #(some #{%} played-moves) winning-condition))
        '((1 2 3) (4 5 6) (7 8 9) (1 4 7) (2 5 8) (3 6 9) (1 5 9) (3 5 7))))

(defn start-game [player1-name player2-name]
  (loop
    [x 9
     players {player1-name () player2-name ()}
     index 0]
    (when (> x 0) (do
                    (def player-name (nth (keys players) (mod index 2)))
                    (def current-player-moves (concat (players player-name) (list (read))))
                    (if (has-won current-player-moves)
                      (println player-name " won ")
                      (recur (dec x) (assoc players player-name current-player-moves) (inc index)))
                    ))))

(start-game
  (do (println " Enter player 1 name ") (read))
  (do (println " Enter player 2 name ") (read)))