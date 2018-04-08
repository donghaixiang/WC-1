| PSP2.1                                  | PSP 阶段                 | 预估耗时 （分钟） | 实际耗时 （分钟） |
| --------------------------------------- | ---------------------- | --------- | --------- |
| Planning                                | 计划                     | 25        | 30        |
| · Estimate                              | · 估计这个任务需要多少时间         | 20        | 30        |
| Development                             | 开发                     | 130       | 270       |
| · Analysis                              | · 需求分析 (包括学习新技术)       | 15        | 20        |
| · Design Spec                           | · 生成设计文档               | 0         | 0         |
| · Design Review                         | · 设计复审 (和同事审核设计文档)     | 0         | 0         |
| · Coding Standard                       | · 代码规范 (为目前的开发制定合适的规范) | 2         | 2         |
| · Design                                | · 具体设计                 | 20        | 30        |
| · Coding                                | · 具体编码                 | 120       | 150       |
| · Code Review                           | · 代码复审                 | 20        | 10        |
| · Test                                  | · 测试（自我测试，修改代码，提交修改）   | 10        | 60        |
| Reporting                               | 报告                     | 60        | 30        |
| · Test Report                           | · 测试报告                 | 10        | 5         |
| · Size Measurement                      | · 计算工作量                | 10        | 5         |
| · Postmortem & Process Improvement Plan | · 事后总结, 并提出过程改进计划      | 20        | 20        |
|                                         | 合计                     | 462       | 642       |

## 解题思路

将不同的选项参数交由不同的函数处理。

空格、逗号和句号作为分隔符，连续空格视为一个空格。

支持的参数使用枚举类来定义，过滤掉不支持的参数。



## 程序设计实现 

- 参数枚举类 

  ```kotlin
  enum class com.dashmrl.wc.Options(val value: String) {
      C("-c"),// 字符数
      W("-w"),// 单词数
      L("-l"),// 行数
      O("-o")// 输出文件
  }
  ```

- 参数检查函数 

  ```kotlin
  fun com.dashmrl.wc.checkArgs(pindex: Int, pc: Int, msg: String): Boolean {
      if (pindex <= -1) return false
      if (pindex + 1 == pc) {
          throw IllegalArgumentException(msg)
      }

      return true
  }
  ```

- 单词统计函数 

  ```
  fun com.dashmrl.wc.calWordCount(ifile: File): Int {
      println("start calculating word count")
      return ifile.readLines().sumBy {
          it.split(
                  ' ', ',', '.',
                  ignoreCase = false,
                  limit = 0).filter { it.isNotEmpty() }.size
      }
  }
  ```

- 输出结果函数 

  ```Kotlin
  fun com.dashmrl.wc.outputResult(input: String, cc: Int, wc: Int, lc: Int, of: File) {
      val sb = StringBuilder(input)
      if (cc != -1) {
          sb.append(",").append(com.dashmrl.wc.Options.C.value).append(":").append(cc)
      }
      if (wc != -1) {
          sb.append(",").append(com.dashmrl.wc.Options.W.value).append(":").append(wc)
      }
      if (lc != -1) {
          sb.append(",").append(com.dashmrl.wc.Options.L.value).append(":").append(lc)
      }
      if (of.exists() && of.isFile) {
          of.delete()
      }

      println("write the result to ${of.absolutePath}")
      of.writeText(sb.toString())
  }
  ```

  ​

## 测试 bat 脚本 

```powershell
WordCount.exe -c input.txt
WordCount.exe -w input.txt
WordCount.exe -l -o result.txt input.txt
WordCount.exe -c -w -l -o result.txt input.txt
```



## 总结 

系统测试在测试中占比非常小的部分，收益远没有单元测试高。

jar 包打包成 exe 不论对于测试和作业，都显得非常多余，找打包软件花费至少半天时间。