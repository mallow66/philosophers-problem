# philosophers-problem

The Dining Philosophers problems is a classic synchronization problem (E. W. Dijkstra. Co-operating Sequential Processes. In F. Genuys (ed.) Programming Languages, Academic Press, London, 1965) introducing semaphores as a conceptual synchronization mechanism. The problem is discussed in just about every operating systems textbook.
Dining Philosophers. There is a dining room containing a circular table with five chairs. At each chair is a plate, and between each plate is a single chopstick. In the middle of the table is a bowl of spaghetti. Near the room are five philosophers who spend most of their time thinking, but who occasionally get hungry and need to eat so they can think some more.

In order to eat, a philosopher must sit at the table, pick up the two chopsticks to the left and right of a plate, then serve and eat the spaghetti on the plate.

Thus, each philosopher is represented by the following pseudocode:

        process P[i]
          while true do
            { THINK;
              PICKUP(CHOPSTICK[i], CHOPSTICK[i+1 mod 5]);
              EAT;
              PUTDOWN(CHOPSTICK[i], CHOPSTICK[i+1 mod 5])
             }
