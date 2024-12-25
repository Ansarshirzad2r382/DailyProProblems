class UniquePath:
    '''
    Aufgabestellung: 

    UniquePaths

    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


    Input: m = 3, n = 7
    Output: 28
    Example 2:

    Input: m = 3, n = 2
    Output: 3
    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down

    Schritt 1:
    Um die Aufgabe zu lösen, erstelle ich zunächst eine m x n-Matrix, die ich für die Speicherung der Anzahl der Wege zu den einzelnen Zellen benutze. Die erste Zeile und die erste Spalte setze ich komplett auf 1, da es nur jeweils einen Weg gibt, um eine Zelle in der ersten Zeile oder der ersten Spalte zu erreichen (entweder nur nach rechts oder nur nach unten).

    Schritt 2:
    Ab der zweiten Zeile und der zweiten Spalte berechne ich die Anzahl der Wege zu einer Zelle mit der Formel:
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1].
    Das bedeutet, dass die Anzahl der Wege zu einer Zelle gleich der Summe der Wege zur Zelle darüber und der Zelle links daneben ist. Ich fülle die Matrix so schrittweise aus, bis ich die untere rechte Ecke erreiche, wo das Ergebnis steht.
    '''
    
    def unique_paths(self, m: int, n: int) -> int:
        # Erstelle eine 2D-Liste (m x n) zur Speicherung der Anzahl der Wege
        dp = [[0] * n for _ in range(m)]

        # erste Zeile und Spalte mit 1 initialisieren
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1

        # anzahl der wege fuer jede Zelle berechnen
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        
        return dp[m - 1][n - 1]


solver = UniquePath()
print(solver.unique_paths(3, 7))  # Ausgabe: 28
print(solver.unique_paths(3, 2))  # Ausgabe: 3
