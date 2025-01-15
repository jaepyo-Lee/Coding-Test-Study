S = input()
T = input()
# #                                   B
# #               BA                                     BB

# #       BAA              ABB                   BBA             BBB

# # BAAA     AABB     ABBA      BBAB        BBAA    ABBB   BBBA        BBBB

strings = [S]
while strings and len(strings[0]) < len(T):
    nxt_strings = []
    for string in strings:
        if string in T:
            nxt_strings.append(string + "A")
            nxt_strings.append(''.join(reversed(string)) + "B")

    strings = nxt_strings

if T in nxt_strings:
    print(1)
else:
    print(0)
