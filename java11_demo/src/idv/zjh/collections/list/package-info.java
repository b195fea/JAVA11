/**
 * <h1>List 繼承順序</h1>
 * 		<b>List -> Collection -> Iterable</b>
 * <ul>Iterable</ul>
 * 		<li>Iterable</li> 建構子，進行迭代
 * 		<li>forEach</li> java8 新增
 * 		<li>spliterator</li> java8 新增
 * <ul>Collection</ul>
 *      <li>
 *      	<ul>Iterator</ul>迭代器
 *      		<li>hasNext</li>是否有下一個值
 *      		<li>next</li>迭代到下一個值
 *      		<li>remove</li> 從底層集合移除有該迭代器返回的最後一個元素
 *      		<li>forEachRemaining</li> java8 新增
 *      <li>
 * 		<li>size</li> 返回結合大小
 * 		<li>isEmpty</li> 是否為空
 * 		<li>contains</li> 返回是否包含物件
 * 		<li>toArray</li> java8 新增
 * 		<li>IntFunction</li> java8 新增
 * 		<li>add</li> java8 新增
 * 		<li>remove</li> java8 新增
 * 		<li>containsAll</li> java8 新增
 * 		<li>addAll</li> java8 新增
 * 		<li>removeAll</li> java8 新增
 * 		<li>removeIf</li> java8 新增
 * 		<li>retainAll</li> java8 新增
 * 		<li>clear</li> java8 新增
 * 		<li>equals</li> java8 新增
 * 		<li>hashCode</li> java8 新增
 * 		<li>stream</li> java8 新增
 * 		<li>parallelStream</li> java8 新增
 */
/**
 * @author zjh
 *
 */
package idv.zjh.collections.list;