# Dinning-Philosophers
Dinning Philosophers problem solution using java.util.concurrent.locks.Lock;

Problem description:
  Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.
Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when they have both left and right forks.  Each fork can be held by only one philosopher and so a philosopher can use the fork only if it is not being used by another philosopher. After an individual philosopher finishes eating, they need to put down both forks so that the forks become available to others. A philosopher can only take the fork on their right or the one on their left as they become available and they cannot start eating before getting both forks.

Solution:
  My solution is that every philosopher can only start eating when he has successfully picked up two forks(chopstick) at once. If philosopher has taken only one, and the other fork is already occupied, he puts this fork down and continues to think.
