package contest;

import template.io.FastInput;
import template.io.FastOutput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GrundysGame {
    Set<Integer> set = new HashSet<>();
    void G(int a, int b){
        if(b == 0){
            set.add(a);
        }
    }
    {
        G(       0,  0  );G(       1,  0  );G(       2,  0  );G(       3,  1  );G(       4,  0
        );G(       6,  1  );G(       7,  0  );G(       9,  1  );G(      10,  0  );G(      12,  1
        );G(      15,  1  );G(      20,  0  );G(      23,  0  );G(      26,  0  );G(      28,  1
        );G(      31,  1  );G(      34,  1  );G(      37,  1  );G(      40,  1  );G(      43,  1
        );G(      46,  1  );G(      49,  1  );G(      50,  0  );G(      52,  1  );G(      53,  0
        );G(      55,  1  );G(      58,  1  );G(      61,  1  );G(      87,  7  );G(      90,  7
        );G(      93,  7  );G(     146,  6  );G(     149,  6  );G(     152,  6  );G(     158, 11
        );G(     161, 11  );G(     164, 11  );G(     167, 11  );G(     176,  7  );G(     179,  7
        );G(     181, 12  );G(     182,  7  );G(     185,  7  );G(     188,  7  );G(     190, 12
        );G(     193, 12  );G(     196, 10  );G(     231, 10  );G(     232,  1  );G(     235,  1
        );G(     238,  1  );G(     270,  0  );G(     273,  0  );G(     276,  0  );G(     281,  1
        );G(     282,  0  );G(     284,  1  );G(     285,  0  );G(     287,  1  );G(     288,  0
        );G(     290,  1  );G(     291, 13  );G(     293,  1  );G(     294, 13  );G(     296,  1
        );G(     297, 13  );G(     299,  1  );G(     300, 13  );G(     302,  1  );G(     303, 13
        );G(     305,  1  );G(     306, 13  );G(     308,  1  );G(     309, 13  );G(     312, 13
        );G(     315, 13  );G(     316,  0  );G(     324,  1  );G(     327,  1  );G(     330,  1
        );G(     333,  1  );G(     334,  0  );G(     336,  1  );G(     337,  0  );G(     338, 12
        );G(     339,  1  );G(     340,  0  );G(     341, 12  );G(     342,  1  );G(     345,  1
        );G(     346,  0  );G(     348,  1  );G(     351,  1  );G(     359,  0  );G(     362,  0
        );G(     365,  0  );G(     379, 12  );G(     380,  7  );G(     383,  7  );G(     386,  0
        );G(     389,  0  );G(     392,  0  );G(     451, 11  );G(     454, 11  );G(     456,  7
        );G(     457, 11  );G(     460, 11  );G(     469,  7  );G(     474,  7  );G(     500, 11
        );G(     503, 11  );G(     507,  6  );G(     510,  6  );G(     512, 13  );G(     513,  6
        );G(     515, 13  );G(     516,  6  );G(     519,  6  );G(     522,  6  );G(     524, 10
        );G(     525,  1  );G(     527, 10  );G(     528,  1  );G(     541, 21  );G(     544, 21
        );G(     566,  0  );G(     584, 13  );G(     587, 13  );G(     590, 13  );G(     593, 13
        );G(     596, 13  );G(     599, 13  );G(     601,  1  );G(     602, 13  );G(     604,  1
        );G(     605, 13  );G(     611, 21  );G(     620, 18  );G(     623, 18  );G(     624, 13
        );G(     626, 18  );G(     627, 13  );G(     629, 18  );G(     630,  0  );G(     633,  0
        );G(     634, 12  );G(     636,  0  );G(     639,  0  );G(     645, 24  );G(     648, 21
        );G(     651, 13  );G(     660, 21  );G(     663, 24  );G(     666, 24  );G(     673,  0
        );G(     676,  0  );G(     680, 12  );G(     682,  0  );G(     685,  0  );G(     735, 11
        );G(     738, 11  );G(     741, 11  );G(     757, 12  );G(     760, 12  );G(     763, 12
        );G(     782, 10  );G(     785, 10  );G(     788, 24  );G(     811, 13  );G(     828, 10
        );G(     831, 10  );G(     852, 24  );G(     855, 11  );G(     858, 11  );G(     860, 20
        );G(     863, 20  );G(     866, 20  );G(     877, 24  );G(     883, 13  );G(     886, 13
        );G(     915, 12  );G(     918, 12  );G(     920, 13  );G(     921, 12  );G(     923,  0
        );G(     926,  0  );G(     927, 12  );G(     929,  0  );G(     930, 12  );G(     932,  0
        );G(     941, 13  );G(     944, 13  );G(     955,  1  );G(     956, 24  );G(     958,  1
        );G(     959, 21  );G(     961,  1  );G(     962, 21  );G(     964,  1  );G(     967, 12
        );G(     969, 10  );G(     970, 12  );G(     973, 12  );G(     976, 12  );G(     979, 12
        );G(    1005, 24  );G(    1007,  1  );G(    1010,  1  );G(    1013,  1  );G(    1050, 12
        );G(    1053, 12  );G(    1063, 10  );G(    1066, 10  );G(    1068,  6  );G(    1069, 10
        );G(    1072, 10  );G(    1074,  6  );G(    1075, 10  );G(    1077,  6  );G(    1083, 11
        );G(    1086, 11  );G(    1106,  7  );G(    1109,  7  );G(    1112,  7  );G(    1117, 12
        );G(    1127, 10  );G(    1188, 21  );G(    1191, 21  );G(    1199, 12  );G(    1202, 12
        );G(    1204,  7  );G(    1205, 12  );G(    1207,  7  );G(    1210,  7  );G(    1213, 13
        );G(    1216, 13  );G(    1222,  0  );G(    1252, 21  );G(    1255, 21  );G(    1258, 21
        );G(    1260,  1  );G(    1261, 21  );G(    1266, 12  );G(    1284, 20  );G(    1290, 25
        );G(    1291, 35  );G(    1294, 35  );G(    1297,  1  );G(    1299, 30  );G(    1301, 13
        );G(    1304, 13  );G(    1306, 12  );G(    1311, 10  );G(    1317, 10  );G(    1334, 12
        );G(    1343,  1  );G(    1347, 24  );G(    1349, 36  );G(    1350, 24  );G(    1379, 11
        );G(    1382, 11  );G(    1393, 37  );G(    1396, 37  );G(    1398, 12  );G(    1400, 19
        );G(    1403, 19  );G(    1404, 36  );G(    1407, 12  );G(    1410, 12  );G(    1413, 12
        );G(    1425, 11  );G(    1442, 13  );G(    1445,  7  );G(    1447, 24  );G(    1458, 11
        );G(    1462, 12  );G(    1494, 13  );G(    1506, 37  );G(    1509, 37  );G(    1512, 37
        );G(    1529, 36  );G(    1531, 10  );G(    1532, 36  );G(    1534, 10  );G(    1535, 40
        );G(    1538, 40  );G(    1539, 13  );G(    1541, 12  );G(    1542, 13  );G(    1544, 12
        );G(    1547, 12  );G(    1548, 21  );G(    1551, 21  );G(    1553, 12  );G(    1556, 12
        );G(    1557, 21  );G(    1559, 12  );G(    1562, 12  );G(    1565, 12  );G(    1570, 13
        );G(    1576, 13  );G(    1579, 13  );G(    1580, 12  );G(    1582, 13  );G(    1583, 12
        );G(    1586, 20  );G(    1589, 20  );G(    1595, 34  );G(    1600, 21  );G(    1603, 13
        );G(    1605, 12  );G(    1606, 13  );G(    1607, 10  );G(    1610, 10  );G(    1632, 12
        );G(    1649, 13  );G(    1683, 10  );G(    1692, 40  );G(    1707, 10  );G(    1718, 36
        );G(    1732, 37  );G(    1733,  6  );G(    1739, 11  );G(    1741, 37  );G(    1749, 12
        );G(    1752, 12  );G(    1761, 36  );G(    1764, 12  );G(    1801, 24  );G(    1802, 37
        );G(    1840, 40  );G(    1848, 25  );G(    1865, 11  );G(    1866, 41  );G(    1869, 41
        );G(    1876, 20  );G(    1879, 20  );G(    1888, 10  );G(    1894, 30  );G(    1899, 13
        );G(    1960, 13  );G(    1965, 25  );G(    1983, 19  );G(    1986, 19  );G(    1996, 12
        );G(    1999, 31  );G(    2002, 31  );G(    2011, 36  );G(    2020, 36  );G(    2021, 18
        );G(    2023, 36  );G(    2024, 18  );G(    2027, 18  );G(    2030, 18  );G(    2031, 30
        );G(    2032, 41  );G(    2034, 37  );G(    2037, 37  );G(    2045, 12  );G(    2046, 37
        );G(    2048, 12  );G(    2056, 13  );G(    2059, 13  );G(    2063, 36  );G(    2072, 36
        );G(    2075, 36  );G(    2111, 20  );G(    2138, 25  );G(    2162, 41  );G(    2191, 36
        );G(    2215, 25  );G(    2218, 20  );G(    2221, 20  );G(    2248, 30  );G(    2253, 13
        );G(    2277, 31  );G(    2314, 13  );G(    2320, 18  );G(    2324, 30  );G(    2326, 18
        );G(    2327, 30  );G(    2332, 12  );G(    2335, 12  );G(    2338, 12  );G(    2353, 31
        );G(    2356, 31  );G(    2362, 36  );G(    2363, 18  );G(    2368, 36  );G(    2404, 19
        );G(    2407, 20  );G(    2465, 40  );G(    2471, 20  );G(    2497, 21  );G(    2533, 35
        );G(    2555, 18  );G(    2558, 18  );G(    2576, 31  );G(    2579, 31  );G(    2581, 20
        );G(    2582, 31  );G(    2600, 35  );G(    2613, 18  );G(    2614, 30  );G(    2616, 18
        );G(    2619, 18  );G(    2629, 30  );G(    2642, 20  );G(    2645, 19  );G(    2648, 20
        );G(    2654, 19  );G(    2655, 35  );G(    2657, 19  );G(    2660, 19  );G(    2661, 35
        );G(    2664, 35  );G(    2666, 30  );G(    2669, 30  );G(    2672, 30  );G(    2678, 37
        );G(    2702, 37  );G(    2704, 35  );G(    2707, 36  );G(    2710, 35  );G(    2716, 35
        );G(    2718, 19  );G(    2719, 36  );G(    2731, 35  );G(    2762, 36  );G(    2798, 30
        );G(    2805, 21  );G(    2819, 20  );G(    2822, 20  );G(    2842, 21  );G(    2845, 21
        );G(    2848, 18  );G(    2851, 21  );G(    2965, 30  );G(    2969, 36  );G(    2971, 30
        );G(    2983, 34  );G(    2992, 37  );G(    3000, 35  );G(    3003, 35  );G(    3006, 35
        );G(    3009, 35  );G(    3012, 36  );G(    3015, 36  );G(    3021, 35  );G(    3024, 35
        );G(    3032, 59  );G(    3038, 37  );G(    3041, 37  );G(    3047, 37  );G(    3050, 34
        );G(    3053, 34  );G(    3054, 19  );G(    3056, 34  );G(    3059, 34  );G(    3090, 37
        );G(    3093, 37  );G(    3096, 34  );G(    3108, 34  );G(    3124, 20  );G(    3135, 31
        );G(    3138, 31  );G(    3155, 46  );G(    3158, 46  );G(    3176, 20  );G(    3179, 20
        );G(    3182, 20  );G(    3197, 60  );G(    3224, 37  );G(    3227, 34  );G(    3230, 34
        );G(    3238, 35  );G(    3276, 34  );G(    3288, 37  );G(    3290, 31  );G(    3291, 37
        );G(    3295, 19  );G(    3298, 19  );G(    3299, 31  );G(    3302, 10  );G(    3305, 31
        );G(    3317, 35  );G(    3318, 18  );G(    3320, 36  );G(    3321, 18  );G(    3326, 36
        );G(    3328, 30  );G(    3330, 18  );G(    3331, 34  );G(    3334, 34  );G(    3343, 37
        );G(    3346, 34  );G(    3352, 34  );G(    3355, 34  );G(    3369, 35  );G(    3372, 36
        );G(    3380, 37  );G(    3383, 37  );G(    3386, 37  );G(    3389, 34  );G(    3392, 34
        );G(    3395, 34  );G(    3398, 34  );G(    3401, 34  );G(    3418, 36  );G(    3437, 21
        );G(    3462, 12  );G(    3500, 13  );G(    3503, 13  );G(    3562, 21  );G(    3574, 31
        );G(    3578, 34  );G(    3581, 37  );G(    3586, 31  );G(    3616, 10  );G(    3619, 36
        );G(    3630, 34  );G(    3639, 11  );G(    3648, 34  );G(    3651, 37  );G(    3673, 30
        );G(    3674, 36  );G(    3675, 18  );G(    3676, 30  );G(    3679, 34  );G(    3682, 47
        );G(    3685, 47  );G(    3694, 34  );G(    3714, 36  );G(    3738, 35  );G(    3741, 13
        );G(    3760, 58  );G(    3771, 20  );G(    3797, 21  );G(    3874, 11  );G(    3892, 37
        );G(    3900, 35  );G(    3932, 11  );G(    3943, 31  );G(    3944, 11  );G(    3952, 10
        );G(    3957, 59  );G(    3967, 10  );G(    3979, 13  );G(    4037, 41  );G(    4062, 46
        );G(    4068, 46  );G(    4072, 12  );G(    4075, 12  );G(    4086, 13  );G(    4129, 13
        );G(    4130, 12  );G(    4132, 13  );G(    4138, 13  );G(    4167, 12  );G(    4170, 11
        );G(    4173, 11  );G(    4179, 12  );G(    4189, 20  );G(    4202, 10  );G(    4205, 10
        );G(    4206, 21  );G(    4226, 10  );G(    4229, 10  );G(    4240, 11  );G(    4249, 11
        );G(    4254, 10  );G(    4257, 10  );G(    4258, 11  );G(    4260, 10  );G(    4263, 10
        );G(    4266, 10  );G(    4272, 10  );G(    4277, 11  );G(    4286, 11  );G(    4292, 47
        );G(    4315, 10  );G(    4318, 10  );G(    4355, 46  );G(    4359, 12  );G(    4361, 41
        );G(    4362, 12  );G(    4365, 12  );G(    4376, 10  );G(    4377, 12  );G(    4391, 41
        );G(    4403, 13  );G(    4423, 47  );G(    4440, 10  );G(    4466, 12  );G(    4469, 12
        );G(    4484, 47  );G(    4497, 20  );G(    4506, 60  );G(    4519, 10  );G(    4539, 11
        );G(    4554, 58  );G(    4565, 46  );G(    4568, 10  );G(    4571, 10  );G(    4574, 10
        );G(    4588, 11  );G(    4594, 11  );G(    4597, 11  );G(    4603, 11  );G(    4613, 47
        );G(    4614, 10  );G(    4620, 10  );G(    4631, 60  );G(    4640, 11  );G(    4643, 11
        );G(    4646, 11  );G(    4649, 11  );G(    4652, 11  );G(    4666, 10  );G(    4699, 13
        );G(    4722, 12  );G(    4725, 12  );G(    4728, 12  );G(    4731, 12  );G(    4765, 12
        );G(    4838, 11  );G(    4879, 10  );G(    4951, 11  );G(    4954, 11  );G(    4956, 10
        );G(    4971, 10  );G(    4983, 10  );G(    4986, 10  );G(    5006, 68  );G(    5029, 10
        );G(    5070, 67  );G(    5096, 10  );G(    5107, 67  );G(    5160, 66  );G(    5171, 68
        );G(    5180, 11  );G(    5273, 10  );G(    5276, 13  );G(    5285, 60  );G(    5342, 67
        );G(    5380, 66  );G(    5383, 66  );G(    5392, 66  );G(    5394, 67  );G(    5397, 67
        );G(    5400, 68  );G(    5441, 69  );G(    5444, 66  );G(    5450, 66  );G(    5453, 66
        );G(    5455, 67  );G(    5456, 66  );G(    5465, 13  );G(    5496, 69  );G(    5499, 69
        );G(    5512, 48  );G(    5574, 60  );G(    5635, 60  );G(    5638, 67  );G(    5676, 66
        );G(    5694, 69  );G(    5721, 54  );G(    5743, 66  );G(    5746, 69  );G(    5749, 69
        );G(    5767, 13  );G(    5775, 67  );G(    5778, 67  );G(    5781, 67  );G(    5783, 66
        );G(    5792, 66  );G(    5829, 61  );G(    5855, 60  );G(    5870, 60  );G(    5875, 48
        );G(    5878, 48  );G(    5881, 48  );G(    5928, 60  );G(    5940, 67  );G(    5965, 49
        );G(    5968, 49  );G(    6033, 66  );G(    6036, 66  );G(    6042, 66  );G(    6052, 55
        );G(    6068, 67  );G(    6074, 68  );G(    6077, 68  );G(    6080, 68  );G(    6092, 68
        );G(    6106, 66  );G(    6111, 68  );G(    6117, 67  );G(    6120, 67  );G(    6150, 41
        );G(    6172, 67  );G(    6195, 61  );G(    6198, 61  );G(    6200, 49  );G(    6201, 69
        );G(    6223, 48  );G(    6232, 48  );G(    6258, 49  );G(    6339, 48  );G(    6370, 68
        );G(    6466, 69  );G(    6469, 69  );G(    6494, 69  );G(    6529, 68  );G(    6534, 48
        );G(    6554, 49  );G(    6555, 66  );G(    6569, 49  );G(    6574, 48  );G(    6577, 48
        );G(    6592, 48  );G(    6609, 49  );G(    6612, 49  );G(    6618, 49  );G(    6794, 68
        );G(    6848, 69  );G(    6853, 49  );G(    6891, 48  );G(    6940, 48  );G(    6972, 54
        );G(    6983, 46  );G(    6997, 47  );G(    7024, 54  );G(    7067, 69  );G(    7090, 68
        );G(    7120, 48  );G(    7129, 72  );G(    7141, 69  );G(    7147, 69  );G(    7170, 68
        );G(    7173, 60  );G(    7176, 60  );G(    7179, 60  );G(    7231, 24  );G(    7250, 47
        );G(    7257, 66  );G(    7263, 40  );G(    7269, 25  );G(    7273, 46  );G(    7288, 46
        );G(    7318, 25  );G(    7335, 78  );G(    7359, 46  );G(    7375, 72  );G(    7392, 68
        );G(    7405, 24  );G(    7443, 66  );G(    7469, 31  );G(    7470, 40  );G(    7475, 67
        );G(    7498, 66  );G(    7526, 79  );G(    7553, 40  );G(    7561, 80  );G(    7573, 73
        );G(    7585, 41  );G(    7605, 79  );G(    7613, 79  );G(    7614, 66  );G(    7616, 80
        );G(    7619, 80  );G(    7623, 66  );G(    7625, 80  );G(    7633, 46  );G(    7642, 73
        );G(    7660, 79  );G(    7672, 66  );G(    7675, 79  );G(    7694, 73  );G(    7697, 73
        );G(    7700, 73  );G(    7723, 40  );G(    7724, 81  );G(    7756, 73  );G(    7767, 81
        );G(    7778, 40  );G(    7800, 30  );G(    7811, 73  );G(    7814, 73  );G(    7817, 68
        );G(    7820, 68  );G(    7822, 81  );G(    7823, 68  );G(    7826, 68  );G(    7846, 72
        );G(    7857, 79  );G(    7861, 69  );G(    7872, 73  );G(    7890, 41  );G(    7909, 79
        );G(    7933, 78  );G(    7935, 46  );G(    7936, 78  );G(    7962, 66  );G(    7964, 47
        );G(    7965, 66  );G(    7983, 47  );G(    7991, 78  );G(    8000, 67  );G(    8003, 67
        );G(    8055, 78  );G(    8064, 46  );G(    8066, 81  );G(    8099, 47  );G(    8107, 73
        );G(    8127, 72  );G(    8133, 72  );G(    8136, 72  );G(    8148, 69  );G(    8153, 73
        );G(    8189, 78  );G(    8205, 80  );G(    8226, 78  );G(    8237, 78  );G(    8247, 41
        );G(    8250, 41  );G(    8275, 78  );G(    8281, 78  );G(    8310, 79  );G(    8322, 79
        );G(    8325, 79  );G(    8331, 79  );G(    8345, 78  );G(    8350, 73  );G(    8360, 46
        );G(    8363, 46  );G(    8382, 72  );G(    8423, 72  );G(    8435, 69  );G(    8455, 73
        );G(    8473, 68  );G(    8545, 81  );G(    8548, 81  );G(    8568, 80  );G(    8580, 78
        );G(    8597, 79  );G(    8603, 79  );G(    8635, 78  );G(    8638, 78  );G(    8641, 78
        );G(    8653, 78  );G(    8673, 79  );G(    8693, 78  );G(    8699, 78  );G(    8792, 79
        );G(    8819, 37  );G(    8836, 97  );G(    8842, 36  );G(    8905, 79  );G(    8954, 81
        );G(    8960, 79  );G(    8978, 96  );G(    8986, 80  );G(    8989, 78  );G(    9013, 35
        );G(    9184, 36  );G(    9187, 36  );G(    9224, 80  );G(    9521, 37  );G(    9550, 36
        );G(    9762, 37  );G(    9966, 73  );G(    9981, 78  );G(   10113, 96  );G(   10167, 58
        );G(   10186, 90  );G(   10204, 73  );G(   10238, 96  );G(   10288, 72  );G(   10326, 78
        );G(   10374, 12  );G(   10399, 61  );G(   10402, 61  );G(   10418, 78  );G(   10445, 67
        );G(   10482, 73  );G(   10512, 67  );G(   10547, 59  );G(   10550, 59  );G(   10570, 58
        );G(   10573, 58  );G(   10596, 59  );G(   10597, 12  );G(   10599, 59  );G(   10602, 59
        );G(   10605, 59  );G(   10606, 12  );G(   10650, 96  );G(   10653, 96  );G(   10680, 67
        );G(   10686, 67  );G(   10695, 78  );G(   10714, 10  );G(   10730, 60  );G(   10750, 61
        );G(   10773, 66  );G(   10778, 67  );G(   10791, 60  );G(   10794, 60  );G(   10796, 67
        );G(   10797, 60  );G(   10815, 13  );G(   10819, 79  );G(   10822, 69  );G(   10839, 78
        );G(   10840, 72  );G(   10842, 73  );G(   10859, 12  );G(   10885, 13  );G(   10894, 13
        );G(   10905, 12  );G(   10908, 11  );G(   10909, 68  );G(   10917, 72  );G(   10918, 68
        );G(   10921, 78  );G(   10943, 13  );G(   10976, 67  );G(   10998, 13  );G(   11000, 61
        );G(   11030, 12  );G(   11052, 61  );G(   11062, 78  );G(   11075, 86  );G(   11084, 60
        );G(   11135, 78  );G(   11140, 11  );G(   11153, 68  );G(   11174, 58  );G(   11176, 72
        );G(   11180, 58  );G(   11181, 13  );G(   11182, 72  );G(   11196, 73  );G(   11203, 59
        );G(   11207, 12  );G(   11208, 68  );G(   11213, 12  );G(   11217, 93  );G(   11223, 58
        );G(   11226, 78  );G(   11229, 58  );G(   11262, 12  );G(   11264, 59  );G(   11275, 78
        );G(   11284, 58  );G(   11296, 61  );G(   11323, 12  );G(   11325, 60  );G(   11348, 61
        );G(   11358, 78  );G(   11364, 96  );G(   11370, 67  );G(   11407, 13  );G(   11442, 58
        );G(   11443, 67  );G(   11446, 67  );G(   11463, 66  );G(   11468, 13  );G(   11471, 13
        );G(   11482, 61  );G(   11483, 13  );G(   11489, 13  );G(   11494, 12  );G(   11511, 59
        );G(   11513, 67  );G(   11514, 59  );G(   11530, 69  );G(   11535, 10  );G(   11536, 72
        );G(   11542, 69  );G(   11548, 69  );G(   11550, 68  );G(   11556, 68  );G(   11562, 68
        );G(   11565, 68  );G(   11592,107  );G(   11600, 79  );G(   11612,109  );G(   11619, 12
        );G(   11642, 13  );G(   11644,117  );G(   11645, 13  );G(   11650,107  );G(   11651, 10
        );G(   11656, 61  );G(   11660, 10  );G(   11669, 67  );G(   11677, 12  );G(   11686, 12
        );G(   11759, 69  );G(   11768, 69  );G(   11771, 69  );G(   11785, 13  );G(   11800, 68
        );G(   11806, 73  );G(   11811, 12  );G(   11817, 12  );G(   11823, 69  );G(   11843, 13
        );G(   11890, 69  );G(   11893, 69  );G(   11908,106  );G(   11910, 68  );G(   11914,106
        );G(   11934,107  );G(   11937,108  );G(   11950, 60  );G(   11961, 12  );G(   11973, 12
        );G(   12004,107  );G(   12013, 61  );G(   12020, 67  );G(   12029, 67  );G(   12037,127
        );G(   12056,102  );G(   12068,107  );G(   12087, 68  );G(   12117,107  );G(   12129,108
        );G(   12140,109  );G(   12154, 68  );G(   12165, 79  );G(   12171, 12  );G(   12175,108
        );G(   12186, 66  );G(   12213,109  );G(   12216,109  );G(   12220, 72  );G(   12229, 69
        );G(   12233,107  );G(   12253,106  );G(   12262,106  );G(   12268,106  );G(   12271,109
        );G(   12280, 60  );G(   12282, 97  );G(   12309,108  );G(   12364,107  );G(   12385, 12
        );G(   12437, 12  );G(   12455, 12  );G(   12458, 12  );G(   12460,109  );G(   12479,106
        );G(   12480,108  );G(   12516, 12  );G(   12565, 92  );G(   12599,108  );G(   12625,106
        );G(   12626, 81  );G(   12683,106  );G(   12724, 92  );G(   12727, 91  );G(   12736, 79
        );G(   12779,108  );G(   12828,108  );G(   12904, 91  );G(   12919, 91  );G(   12948, 80
        );G(   13009, 80  );G(   13090, 79  );G(   13096, 81  );G(   13137, 93  );G(   13168,121
        );G(   13169, 86  );G(   13313,127  );G(   13334, 81  );G(   13337, 79  );G(   13357, 80
        );G(   13398, 86  );G(   13430, 80  );G(   13438, 92  );G(   13476, 80  );G(   13543, 87
        );G(   13586, 90  );G(   13615,108  );G(   13679,133  );G(   13688, 81  );G(   13700, 81
        );G(   13715, 96  );G(   13778, 80  );G(   13803, 25  );G(   13908,127  );G(   13917, 91
        );G(   13955, 93  );G(   13963,130  );G(   13972,133  );G(   13975,133  );G(   13998,132
        );G(   14022, 80  );G(   14034, 97  );G(   14035, 25  );G(   14059, 93  );G(   14061, 24
        );G(   14222, 92  );G(   14239,132  );G(   14270, 25  );G(   14271,133  );G(   14300,132
        );G(   14305, 24  );G(   14360, 24  );G(   14383, 25  );G(   14416, 93  );G(   14421, 24
        );G(   14451,106  );G(   14505, 25  );G(   14507,127  );G(   14601, 24  );G(   14802,106
        );G(   14935, 25  );G(   15422,130  );G(   15425,130  );G(   15603,108  );G(   15620,126
        );G(   15689,132  );G(   15692,132  );G(   15721,130  );G(   15727,130  );G(   15773,130
        );G(   15800,106  );G(   15936,127  );G(   15963,108  );G(   15980,115  );G(   15992, 96
        );G(   16011,130  );G(   16017,130  );G(   16020,130  );G(   16049,131  );G(   16064,117
        );G(   16098,131  );G(   16204, 11  );G(   16230, 10  );G(   16276,109  );G(   16320, 97
        );G(   16339,132  );G(   16348,131  );G(   16368,130  );G(   16369,117  );G(   16371,130
        );G(   16394,131  );G(   16398,116  );G(   16752,106  );G(   16771, 58  );G(   16848,107
        );G(   16851,107  );G(   16935,109  );G(   16960, 61  );G(   16999,109  );G(   17095,142
        );G(   17193,107  );G(   17310,131  );G(   17505,137  );G(   17676,137  );G(   17760,136
        );G(   17893,142  );G(   17911,137  );G(   17934,136  );G(   17940,136  );G(   17943,136
        );G(   18082,137  );G(   18088,137  );G(   18100,131  );G(   18117,136  );G(   18236,136
        );G(   18280,132  );G(   18291,136  );G(   18312,133  );G(   18335,131  );G(   18384,137
        );G(   18521,132  );G(   18570,132  );G(   18573,132  );G(   18617, 96  );G(   18625,132
        );G(   18628,132  );G(   18663,130  );G(   18695,108  );G(   18721,130  );G(   18735,142
        );G(   18915,132  );G(   18918,132  );G(   19035,106  );G(   19582,130  );G(   19611, 47
        );G(   19687,132  );G(   20455,136  );G(   20507,130  );G(   20774,131  );G(   20775,130
        );G(   20777,131  );G(   20818,130  );G(   20829,137  );G(   20922,136  );G(   20931,130
        );G(   21123,130  );G(   21164,131  );G(   21204,131  );G(   21210,131  );G(   21335,131
        );G(   21352,133  );G(   21355,133  );G(   21375,132  );G(   21401,133  );G(   21654,133
        );G(   21671,132  );G(   21926,133  );G(   21972,136  );G(   22036,136  );G(   22068,131
        );G(   22324,132  );G(   22349, 60  );G(   22401, 60  );G(   22753,133  );G(   22770,131
        );G(   23341, 72  );G(   23423,131  );G(   23478,132  );G(   23693,133  );G(   23710,132
        );G(   23719,132  );G(   23774,132  );G(   23849, 78  );G(   24044,133  );G(   24050,133
        );G(   24175,133  );G(   24285,133  );G(   24327, 79  );G(   24337,130  );G(   24344, 73
        );G(   24383,133  );G(   24386,133  );G(   24465,133  );G(   24893,156  );G(   24978,133
        );G(   25079,136  );G(   25692,130  );G(   26227, 80  );G(   26230, 80  );G(   26285, 80
        );G(   26305, 92  );G(   26317, 81  );G(   26444,161  );G(   26526, 80  );G(   26598, 92
        );G(   26613, 81  );G(   27559,157  );G(   27936,156  );G(   28456,132  );G(   29448,157
        );G(   30877, 92  );G(   32487,192  );G(   32986,193  );G(   33195,199  );G(   33465,193
        );G(   33468,193  );G(   33523,193  );G(   33578,193  );G(   33642,193  );G(   33697,193
        );G(   33842,192  );G(   36041,193  );G(   36184,157  );G(   82860,108  );G(47461861,261
        );G(47482266,258  );G(47595779,259  );G(47844890,260  );G(47846178,260  );G(47850055,260
        );G(47879108,261  );G(47912346,258  );G(48042117,258  );G(48046310,261  );G(48142092,258
        );G(48142376,265  );G(48399022,259);
    }
    public void solve(int testNumber, FastInput in, FastOutput out) {
        int n = in.ri();
        out.println(set.contains(n) ? "second" : "first");
    }
}