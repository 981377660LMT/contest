#ifndef COMMON_H
#define COMMON_H

#pragma GCC target ("sse4.2")

#include <iostream>
#include <fstream>
#include <iomanip>
#include <bits/stdc++.h>
#include <chrono>
#include <random>
#include<ext/rope>

using __gnu_cxx::rope;
using std::cerr;
using std::deque;
using std::endl;
using std::fill;
using std::ios_base;
using std::istream;
using std::iterator;
using std::make_pair;
using std::map;
using std::max;
using std::min;
using std::numeric_limits;
using std::ostream;
using std::pair;
using std::priority_queue;
using std::set;
using std::sort;
using std::string;
using std::swap;
using std::unordered_map;
using std::vector;
using std::bitset;
using std::uniform_int_distribution;
using std::uniform_real_distribution;
using std::stringstream;
using std::istream_iterator;

typedef unsigned int ui;
typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
std::mt19937 rng(std::chrono::steady_clock::now().time_since_epoch().count());

#define error(args...) { string _s = #args; replace(_s.begin(), _s.end(), ',', ' '); stringstream _ss(_s); istream_iterator<string> _it(_ss); err(_it, args); }
void err(std::istream_iterator<string> it) {}
template<typename T, typename... Args>
void err(std::istream_iterator<string> it, T a, Args... args) {
	cerr << *it << " = " << a << endl;
	err(++it, args...);
}

#define mp make_pair
#define popcount __builtin_popcount

#endif