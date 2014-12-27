# Tile Sliders #

Create the classic 3x3 tile slider game where the goal is to take a scrambled set of tiles and allow the user to correct the order by sliding the tiles around.  Track the user’s time taken as well as the number of moves.
Convert a random layout like this:

```

3 1 4
5   2
8 7 6
```

To:

```
1 2 3
4 5 6 
7 8
```
 
* App minimally contains 2 screens, a quiz view and a top scores view.
    * Screens will be implemented as fragments.
    * Top scores show time taken and number of moves.
    * Tiles on quiz view should be images.
* Top scores should be stored in the database.
* Action bar interaction allows you to change views and reset scores.

BONUS – Make the table dynamic, so a user could do a 2x2, 3x3, 4x4, etc. game.  Track the scores for each size separately.