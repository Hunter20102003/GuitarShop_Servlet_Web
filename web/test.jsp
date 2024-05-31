<!-- index.html -->

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Star Rating</title>
        <meta name="viewport"
              content="width=device-width, 
              initial-scale=1" />
        <style>/* style.css */



            body {
                min-height: 50vh;
                display: flex;
                align-items: center;
                text-align: center;
                justify-content: center;
                background: hsl(137, 46%, 24%);
                font-family: "Poppins", sans-serif;
            }

            .card {
                max-width: 33rem;
                background: #fff;
                margin: 0 1rem;
                padding: 1rem;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                width: 100%;
                border-radius: 0.5rem;
            }

            .star {
                font-size: 10vh;
                cursor: pointer;
            }

            .one {
                color: rgb(255, 0, 0);
            }

            .two {
                color: rgb(255, 106, 0);
            }

            .three {
                color: rgb(251, 255, 120);
            }

            .four {
                color: rgb(255, 255, 0);
            }

            .five {
                color: rgb(24, 159, 14);
            }
        </style>
    </head>

    <body>
        <div class="card">
            <h1>JavaScript Star Rating</h1>
            <br />
            <span onclick="gfg(1)"
                  class="star">?
            </span>
            <span onclick="gfg(2)"
                  class="star">?
            </span>
            <span onclick="gfg(3)"
                  class="star">?
            </span>
            <span onclick="gfg(4)"
                  class="star">?
            </span>
            <span onclick="gfg(5)"
                  class="star">?
            </span>
            <h3 id="output">
                Rating is: 0/5
            </h3>
        </div>
        <script >// script.js

// To access the stars
            let stars =
                    document.getElementsByClassName("star");
            let output =
                    document.getElementById("output");

// Funtion to update rating
            function gfg(n) {
                remove();
                for (let i = 0; i < n; i++) {
                    if (n == 1)
                        cls = "one";
                    else if (n == 2)
                        cls = "two";
                    else if (n == 3)
                        cls = "three";
                    else if (n == 4)
                        cls = "four";
                    else if (n == 5)
                        cls = "five";
                    stars[i].className = "star " + cls;
                }
                output.innerText = "Rating is: " + n + "/5";
            }

// To remove the pre-applied styling
            function remove() {
                let i = 0;
                while (i < 5) {
                    stars[i].className = "star";
                    i++;
                }
            }
        </script>
    </body>

</html>
