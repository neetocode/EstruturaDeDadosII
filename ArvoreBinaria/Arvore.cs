using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArvoreBinaria
{
    abstract class Arvore<T>
    {
        public No<T> Raiz { get; set; }
    }
}
